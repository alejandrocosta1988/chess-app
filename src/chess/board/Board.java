package chess.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.NoPiece;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.StringUtil;

public class Board implements Iterable<Piece> {
	
	private Piece[][] board = new Piece[8][8];
	private List<Piece> whitePieces = new ArrayList<>();
	private List<Piece> blackPieces = new ArrayList<>();
	
	public Board() {
		initialize();
	}
	
	private void initialize() {
		for (int rank = 0; rank < 8; rank++)
			generateEmptyRank(rank);
	}
	
	private void generateEmptyRank(int rank) {
		for (int file = 0; file < 8; file++)
			board[rank][file] = NoPiece.noPiece();
	}

	public void setUp() {
		setUpWhiteElitePieces();
		setUpWhitePawns();
		setUpBlackPawns();
		setUpBlackElitePieces();
	}
	
	private void setUpWhiteElitePieces() {
		Piece[] whiteElitePieces = { Rook.createWhiteRook(), Knight.createWhiteKnight(), Bishop.createWhiteBishop(), Queen.createWhiteQueen(), King.createWhiteKing(), Bishop.createWhiteBishop(), Knight.createWhiteKnight(), Rook.createWhiteRook() };
		board[0] = whiteElitePieces;
	}
	
	private void setUpWhitePawns() {
		for (int file = 0; file < 8; file++)
			board[1][file] = Pawn.createWhitePawn();
	}
	
	private void setUpBlackPawns() {
		for (int file = 0; file < 8; file++)
			board[6][file] = Pawn.createBlackPawn();
	}
	
	private void setUpBlackElitePieces() {
		Piece[] blackElitePieces = { Rook.createBlackRook(), Knight.createBlackKnight(),
				Bishop.createBlackBishop(), Queen.createBlackQueen(), King.createBlackKing(),
				Bishop.createBlackBishop(), Knight.createBlackKnight(), Rook.createBlackRook() }; 
		board[7] = blackElitePieces;
	}
	
	public int countPieces() {
		int count = 0;
		for (Piece piece : this) count++;
		return count;
	}
	
	public int countWhitePieces() {
		return countPieces(Piece.Color.WHITE);
	}
	
	private int countPieces(Piece.Color color) {
		int pieces = 0;
		for (int rank = 0; rank < 8; rank++) {
			for (int file = 0; file < 8; file++) {
				if (board[rank][file].getColor() == color)
					pieces++;
			}
		}
		return pieces;
	}
	
	public int countBlackPieces() {
		return countPieces(Piece.Color.BLACK);
	}
	
	public String printBoard() {
		StringBuilder buffer = new StringBuilder();
		for (int i = board.length - 1; i > 0; i--) {
			buffer.append(printRank(board[i]));
			buffer.append(StringUtil.addNewLine());
		}
		buffer.append(printRank(board[0]));
		return buffer.toString();
	}

	public String printRank(Piece[] rank) {
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
	
	private Piece[] getRank(int rank) {
		return board[rank];
	}
	
	private Piece getPieceInRank(Piece[] rank, Character fileCharacter) {
		return rank[fileCharacterToFileInt(fileCharacter)];
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
		getRank(rank)[filePosition] = piece;
	}

	public double evaluateStrength(Color pieceColor) {
		double score = 0d;
		for (int rank = 0; rank < 8; rank++) {
			for (int file = 0; file < 8; file++) {
				Piece piece = board[rank][file];
				if (piece.isColor(pieceColor)) {
					if (piece.isPawn() && isThereOtherPawnInSameFile(file, pieceColor)) {
						score += piece.getHalfScore();
						continue;
					}
					score += piece.getScore();
				}
			}
		}
		return score;
	}
	
	private boolean isThereOtherPawnInSameFile(int file, Piece.Color pieceColor) {
		int count = 0;
		for (int rank = 0; rank < 8; rank++) {
			Piece piece = board[rank][file];
			if (piece.isColor(pieceColor) && piece.isPawn())
				count++;
		}
		return count > 1;
	}

	public void collectWhitePieces() {
		for (Piece piece : this) {
			if (piece.isWhite())
				whitePieces.add(piece);
		}
	}
	
	public List<Piece> getWhitePieces() {
		Collections.sort(whitePieces);
		return whitePieces;
	}

	public void collectBlackPieces() {
		for (Piece piece : this) {
			if (piece.isBlack())
				blackPieces.add(piece);
		}
	}

	public List<Piece> getBlackPieces() {
		Collections.sort(blackPieces);
		return blackPieces;
	}

	public boolean checkPosition(Piece piece, String location) {
		if (getPiece(location) == piece) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Piece> iterator() {
		List<Piece> pieces = new ArrayList<>();
		for (int rank = 0; rank < 8; rank++) {
			for (int file = 0; file < 8; file++) {
				Piece piece = board[rank][file];
				if (piece.isNotBlank())
					pieces.add(piece);
			}
		}
		return pieces.iterator();
	}

}
