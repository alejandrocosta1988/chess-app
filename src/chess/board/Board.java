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

	public void addPawn(Pawn whitePawn01) {
		pieces.add(whitePawn01);
	}

	/**
	 * Checks if the piece is on the board.
	 * @param whitePawn01 piece to be checked.
	 */
	public boolean contains(Pawn whitePawn01) {
		return pieces.contains(whitePawn01);
	}

}
