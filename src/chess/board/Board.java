package chess.board;

import java.util.ArrayList;

import chess.pieces.Pawn;

public class Board {
	
	private ArrayList<Pawn> pieces = new ArrayList<>();

	public Object getNumberOfPieces() {
		return pieces.size();
	}

	public void addPawn(Pawn whitePawn01) {
		pieces.add(whitePawn01);
	}

	public boolean contains(Pawn whitePawn01) {
		return pieces.contains(whitePawn01);
	}

}
