package chess.pieces;

import java.util.List;

import chess.board.Board;
import chess.moves.IntLocations;

public class NoPiece extends Piece {

	private NoPiece() {
		super();
		setScore(0d);
		setPrintableRepresentation('.');
	}
	
	public static Piece noPiece() {
		return new NoPiece();
	}
	
	@Override
	public String getRepresentation() {
		return " " + printableRepresentation + " ";
	}
	
	protected List<String> getPossibleMoves(String location, Board board){
		return null;
	}

	@Override
	public boolean checkMove(IntLocations locations) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
