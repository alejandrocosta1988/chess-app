package chess.board;

import java.util.ArrayList;

import chess.pieces.Pawn;

/**
 * Represents a chess board.
 * @author Alejandro Costa
 */
public class Board {
	
	private ArrayList<Pawn> pieces = new ArrayList<>();

	public Object getNumberOfPieces() {
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

}
