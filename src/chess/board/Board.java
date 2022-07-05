package chess.board;

import java.util.ArrayList;
import java.util.Arrays;

import chess.pieces.Piece;
import util.StringUtil;

/**
 * Represents a chess board.
 * @author Alejandro Costa
 */
public class Board {
	
	private ArrayList<Piece> pieces = new ArrayList<>();
	protected ArrayList<Piece> rank1 = new ArrayList<>();
	protected ArrayList<Piece> rank2 = new ArrayList<>(8);
	protected ArrayList<String> rank3 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank4 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank5 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank6 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<Piece> rank7 = new ArrayList<>(8);
	protected ArrayList<Piece> rank8 = new ArrayList<>();
	
	public Board() {
		initialize();
	}

	public void initialize() {
		rank1.add(Piece.createWhiteRook());
		rank1.add(Piece.createWhiteKnight());
		rank1.add(Piece.createWhiteBishop());
		rank1.add(Piece.createWhiteQueen());
		rank1.add(Piece.createWhiteKing());
		rank1.add(Piece.createWhiteBishop());
		rank1.add(Piece.createWhiteKnight());
		rank1.add(Piece.createWhiteRook());
		
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		rank2.add(Piece.createWhitePawn());
		
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		rank7.add(Piece.createBlackPawn());
		
		rank8.add(Piece.createBlackRook());
		rank8.add(Piece.createBlackKnight());
		rank8.add(Piece.createBlackBishop());
		rank8.add(Piece.createBlackQueen());
		rank8.add(Piece.createBlackKing());
		rank8.add(Piece.createBlackBishop());
		rank8.add(Piece.createBlackKnight());
		rank8.add(Piece.createBlackRook());
	}
	
	public Object getNumberOfPieces() {
		pieces.addAll(rank1);
		pieces.addAll(rank2);
		pieces.addAll(rank7);
		pieces.addAll(rank8);
		return pieces.size();
	}
	
	public void addPawn(Piece pawn) {
		pieces.add(pawn);
	}

	/**
	 * Checks if the piece is on the board.
	 * @param pawn piece to be checked.
	 */
	public boolean contains(Piece piece) {
		return pieces.contains(piece);
	}

	public String printRank(ArrayList<Piece> rank) {
		StringBuilder buffer = new StringBuilder();
		for (Piece piece : rank) {
			buffer.append(piece.toString());
		}
		return buffer.toString();
	}
	
	private String printEmptyRank(ArrayList<String> emptyRank) {
		StringBuilder buffer = new StringBuilder();
		for (String emptySquare : emptyRank) {
			buffer.append(emptySquare.toString());
		}
		return buffer.toString();
	}

	public String printBoard() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(printRank(rank8));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printRank(rank7));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printEmptyRank(rank6));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printEmptyRank(rank5));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printEmptyRank(rank4));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printEmptyRank(rank3));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printRank(rank2));
		buffer.append(StringUtil.addNewLine());
		buffer.append(printRank(rank1));
		return buffer.toString();
	}

}
