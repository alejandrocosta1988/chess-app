package chess.pieces;

import java.util.List;

import chess.board.Board;
import chess.moves.IntLocations;

public class Rook extends Piece {

	private Rook(Piece.Color color) {
		super(color);
		setPrintableRepresentation('r');
		setScore(5d);
	}
	
	public static Piece createBlackRook() {
		return new Rook(Piece.Color.BLACK);
	}

	public static Piece createWhiteRook() {
		return new Rook(Piece.Color.WHITE);
	}
	
	public List<String> getPossibleMoves(String location, Board board){
		return null;
	}

	@Override
	public boolean checkMove(IntLocations locations) {
		// TODO Auto-generated method stub
		return false;
	}

}
