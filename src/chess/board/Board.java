package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;

public class Board {
	
	private ArrayList<Pawn> pieces = new ArrayList<>();

	public Object getNumberOfPieces() {
		return pieces.size();
	}

	public void addPawn(Pawn whitePawn01) {
		pieces.add(whitePawn01);
	}

	public ArrayList<Pawn> getPieces() {
		return pieces;
	}

}
