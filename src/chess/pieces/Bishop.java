package chess.pieces;

import java.util.List;

import chess.board.Board;

public class Bishop extends Piece {

	private Bishop(Piece.Color color) {
		super(color);
		setPrintableRepresentation('b');
		setScore(3d);
	}
	
	public static Piece createBlackBishop() {
		return new Bishop(Piece.Color.BLACK);
	}

	public static Piece createWhiteBishop() {
		return new Bishop(Piece.Color.WHITE);
	}
	
	public List<String> getPossibleMoves(String location, Board board){
		return null;
	}
	
}
