package chess.pieces;

import java.util.List;

import chess.board.Board;

public class Pawn extends Piece {

	public Pawn(Piece.Color color) {
		super(color);
		setPrintableRepresentation('p');
		setScore(1d);
	}

	public static Piece createBlackPawn() {
		return new Pawn(Piece.Color.BLACK);
	}

	public static Piece createWhitePawn() {
		return new Pawn(Piece.Color.WHITE);
	}
	
	public List<String> getPossibleMoves(String location, Board board){
		return null;
	}
	
}
