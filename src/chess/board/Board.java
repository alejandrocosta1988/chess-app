package chess.board;

import java.util.ArrayList;
import java.util.Arrays;

import chess.pieces.Pawn;

/**
 * Represents a chess board.
 * @author Alejandro Costa
 */
public class Board {
	
	static final String NEWLINE = System.getProperty("line.separator");
	
	private ArrayList<Pawn> pieces = new ArrayList<>();
	protected ArrayList<String> rank1 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<Pawn> rank2 = new ArrayList<>(8);
	protected ArrayList<String> rank3 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank4 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank5 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<String> rank6 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	protected ArrayList<Pawn> rank7 = new ArrayList<>(8);
	protected ArrayList<String> rank8 = new ArrayList<>(Arrays.asList(" . "," . "," . "," . "," . "," . "," . "," . "));
	
	public Board() {
		initialize();
	}

	public void initialize() {
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank2.add(new Pawn(Pawn.WHITE));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
		rank7.add(new Pawn(Pawn.BLACK));
	}
	
	public Object getNumberOfPieces() {
		pieces.addAll(rank2);
		pieces.addAll(rank7);
		return pieces.size();
	}
	
	public void addPawn(Pawn pawn) {
		pieces.add(pawn);
	}

	/**
	 * Checks if the piece is on the board.
	 * @param pawn piece to be checked.
	 */
	public boolean contains(Pawn pawn) {
		return pieces.contains(pawn);
	}

	public String printRank(ArrayList<Pawn> rank) {
		StringBuilder buffer = new StringBuilder();
		for (Pawn pawn : rank) {
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
		buffer.append(Board.NEWLINE);
		buffer.append(printRank(rank7));
		buffer.append(Board.NEWLINE);
		buffer.append(printEmptyRank(rank6));
		buffer.append(Board.NEWLINE);
		buffer.append(printEmptyRank(rank5));
		buffer.append(Board.NEWLINE);
		buffer.append(printEmptyRank(rank4));
		buffer.append(Board.NEWLINE);
		buffer.append(printEmptyRank(rank3));
		buffer.append(Board.NEWLINE);
		buffer.append(printRank(rank2));
		buffer.append(Board.NEWLINE);
		buffer.append(printEmptyRank(rank1));
		return buffer.toString();
	}

}
