package chess.pieces;

import java.util.List;

import chess.board.Board;

public class Knight extends Piece {

	private Knight(Piece.Color color) {
		super(color);
		setPrintableRepresentation('n');
		setScore(2.5);
	}
	
	public static Piece createBlackKnight() {
		return new Knight(Piece.Color.BLACK);
	}

	public static Piece createWhiteKnight() {
		return new Knight(Piece.Color.WHITE);
	}
	
	public List<String> getPossibleMoves(String location, Board board){
		return null;
	}

}
