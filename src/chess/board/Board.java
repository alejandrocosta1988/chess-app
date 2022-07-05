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
	protected ArrayList<String> rank1 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<Piece> rank2 = new ArrayList<>(8);
	protected ArrayList<String> rank3 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank4 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank5 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank6 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<Piece> rank7 = new ArrayList<>(8);
	protected ArrayList<String> rank8 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	
	public Board() {
		initialize();
	}

	public void initialize() {
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
	}
	
	public Object getNumberOfPieces() {
		pieces.addAll(rank2);
		pieces.addAll(rank7);
		return pieces.size();
	}
	
	public void addPawn(Piece pawn) {
		pieces.add(pawn);
	}

	/**
	 * Checks if the piece is on the board.
	 * @param pawn piece to be checked.
	 */
	public boolean contains(Piece pawn) {
		return pieces.contains(pawn);
	}

	public String printRank(ArrayList<Piece> rank) {
		StringBuilder buffer = new StringBuilder();
		for (Piece pawn : rank) {
			buffer.append(pawn.toString());
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
		buffer.append(printEmptyRank(rank8));
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
		buffer.append(printEmptyRank(rank1));
		return buffer.toString();
	}

}
