package chess.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import util.StringUtil;

/**
 * Represents a chess board.
 * @author Alejandro Costa
 */
public class Board {
	
	private ArrayList<ArrayList<Piece>> board = new ArrayList<>(8);
	
	public Board() {
		initialize();
	}
	
	private void initialize() {
		for (int rank = 0; rank < 8; rank++) {
			board.add(generateEmptyRank());
		}
	}
	
	private ArrayList<Piece> generateEmptyRank() {
		ArrayList<Piece> emptyRank = new ArrayList<>(8);
		for (int file = 0; file < 8; file++) {
			emptyRank.add(Piece.noPiece());
		}
		return emptyRank;
	}

	public void setUp() {
		board.set(0, setUpWhiteElitePieces());
		setUpWhitePawns();
		setUpBlackPawns();
		board.set(7, createBlackElitePieces());
	}
	
	private ArrayList<Piece> setUpWhiteElitePieces() {
		return new ArrayList<Piece>(Arrays.asList(
				Piece.createWhiteRook(), Piece.createWhiteKnight(),
				Piece.createWhiteBishop(), Piece.createWhiteQueen(), Piece.createWhiteKing(),
				Piece.createWhiteBishop(), Piece.createWhiteKnight(), Piece.createWhiteRook()));
	}
	
	private void setUpWhitePawns() {
		ArrayList<Piece> whitePawnsRank = getRank(1);
		for (int file = 0; file < 8; file++) {
			whitePawnsRank.set(file, Piece.createWhitePawn());
		}
	}
	
	private void setUpBlackPawns() {
		ArrayList<Piece> blackPawnsRank = getRank(6);
		for (int file = 0; file < 8; file++) {
			blackPawnsRank.set(file, Piece.createBlackPawn());
		}
	}
	
	private ArrayList<Piece> createBlackElitePieces() {
		return new ArrayList<Piece>(Arrays.asList(Piece.createBlackRook(), Piece.createBlackKnight(),
				Piece.createBlackBishop(), Piece.createBlackQueen(), Piece.createBlackKing(),
				Piece.createBlackBishop(), Piece.createBlackKnight(), Piece.createBlackRook()));
	}
	
	public int countPieces() {
		int pieces = 0;
		for (ArrayList<Piece> rank : board) {
			for (Piece piece : rank) {
				if (piece.isNotBlank()) {
					pieces++;
				}
			}
		}
		return pieces;
	}
	
	public int countWhitePieces() {
		return countPieces(Piece.Color.WHITE);
	}
	
	private int countPieces(Piece.Color color) {
		int pieces = 0;
		for (ArrayList<Piece> rank : board) {
			for (Piece piece : rank) {
				if (piece.getColor() == color) {
					pieces++;
				}
			}
		}
		return pieces;
	}
	
	public int countBlackPieces() {
		return countPieces(Piece.Color.BLACK);
	}
	
	public int countPieces(Piece.Type type, Piece.Color color) {
		int pieces = 0;
		for (ArrayList<Piece> rank : board) {
			for (Piece piece : rank) {
				if (piece.getType() == type && piece.getColor() == color) {
					pieces++;
				}
			}
		}
		return pieces;
	}
	
	public String printBoard() {
		StringBuilder buffer = new StringBuilder();
		for (int i = board.size() - 1; i > 0; i--) {
			buffer.append(printRank(board.get(i)));
			buffer.append(StringUtil.addNewLine());
		}
		buffer.append(printRank(board.get(0)));
		return buffer.toString();
	}

	public String printRank(ArrayList<Piece> rank) {
		StringBuilder buffer = new StringBuilder();
		for (Piece piece : rank) {
			buffer.append(piece.getRepresentation());
		}
		return buffer.toString();
	}

	public Piece getPiece(String location) {
		int rank = isolateRankNumberFromStringLocation(location);
		return getPieceInRank(getRank(rank), location.charAt(0));
	}
	
	private int isolateRankNumberFromStringLocation(String location) {
		int correctionToConvertToIndex = 1;
		return Character.getNumericValue(location.charAt(1)) - correctionToConvertToIndex;
	}
	
	private ArrayList<Piece> getRank(int rank) {
		return board.get(rank);
	}
	
	private Piece getPieceInRank(ArrayList<Piece> rank, Character fileCharacter) {
		return rank.get(fileCharacterToFileInt(fileCharacter));
	}
	
	private int fileCharacterToFileInt(Character fileCharacter) {
		int file = 0;
		List<Character> fileOptions = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
		for (Character fileOption : fileOptions) {
			if (fileCharacter.equals(fileOption))
				file = fileOptions.indexOf(fileOption);
		}
		return file;
	}
	
	public void placePieceAt(String location, Piece piece) {
		int rank = isolateRankNumberFromStringLocation(location);
		int filePosition = fileCharacterToFileInt(location.charAt(0));
		getRank(rank).set(filePosition, piece);
	}

	public double evaluateStrength(Color pieceColor) {
		double score = 0d;
		for (ArrayList<Piece> rank : board) {
			for (int file = 0; file < 8; file++) {
				Piece piece = rank.get(file);
				if (piece.isColor(pieceColor)) {
					if (piece.isPawn() && isThereOtherPawnInSameFile(file, pieceColor)) {
						score += piece.getHalfPawnScore();
						continue;
					}
					score += piece.getScore();
				}
			}
		}
		return score;
	}
	
	private boolean isThereOtherPawnInSameFile(int file, Piece.Color pieceColor) {
		List<Piece> pawnsInFile = new ArrayList<>();
		for (ArrayList<Piece> rank : board) {
			Piece piece = rank.get(file);
			if (piece.isColor(pieceColor) && piece.isPawn()) {
				pawnsInFile.add(piece);
			}
		}
		return pawnsInFile.size() > 1;
	}

	public void assignStrengthToPieces() {
		for (ArrayList<Piece> rank : board) {
			for (Piece piece : rank) {
				if (piece.isNotBlank()) {
					piece.setStrength();
				}
			}
		}
	}
	
}
