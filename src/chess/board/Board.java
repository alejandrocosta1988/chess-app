package chess.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chess.pieces.Piece;
import util.StringUtil;

/**
 * Represents a chess board.
 * @author Alejandro Costa
 */
public class Board {
	
	private ArrayList<ArrayList<Piece>> board = new ArrayList<>(8);
	
	protected ArrayList<Piece> rank1 = new ArrayList<>();
	protected ArrayList<Piece> rank2 = new ArrayList<>();
	protected ArrayList<Piece> rank7 = new ArrayList<>();
	protected ArrayList<Piece> rank8 = new ArrayList<>();
	
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
		
		rank1.add(Piece.createWhiteRook());
		rank1.add(Piece.createWhiteKnight());
		rank1.add(Piece.createWhiteBishop());
		rank1.add(Piece.createWhiteQueen());
		rank1.add(Piece.createWhiteKing());
		rank1.add(Piece.createWhiteBishop());
		rank1.add(Piece.createWhiteKnight());
		rank1.add(Piece.createWhiteRook());
		
		board.set(0, rank1);
		
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		
		board.set(1, rank2);
		
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		
		board.set(6, rank7);
		
		rank8.add(Piece.createBlackRook());
		rank8.add(Piece.createBlackKnight());
		rank8.add(Piece.createBlackBishop());
		rank8.add(Piece.createBlackQueen());
		rank8.add(Piece.createBlackKing());
		rank8.add(Piece.createBlackBishop());
		rank8.add(Piece.createBlackKnight());
		rank8.add(Piece.createBlackRook());
		
		board.set(7, rank8);
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
		int rank = Character.getNumericValue(location.charAt(1) - 1); // -1 to convert to ArrayList index
		Character file = location.charAt(0);
		return getPieceInRank(getRank(rank), file);
	}
	
	private ArrayList<Piece> getRank(int rank) {
		return board.get(rank);
	}
	
	private Piece getPieceInRank(ArrayList<Piece> rank, Character file) {
		
		int filePosition = 0;
		List<Character> fileOptions = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
		
		for (Character fileOption : fileOptions) {
			if (file.equals(fileOption)) {
				filePosition = fileOptions.indexOf(fileOption);
			}
		}
		
		return rank.get(filePosition);
		
	}

	

}
