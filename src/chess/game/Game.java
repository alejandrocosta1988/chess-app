package chess.game;

import chess.board.Board;
import chess.moves.IntLocations;
import chess.pieces.NoPiece;
import chess.pieces.Piece;

public class Game {

	private Board board;
	
	public Game(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}

	public Piece getPieceAt(String location) {
		return board.getPiece(location);
	}
	
	public void putPieceAt(Piece piece, String location) {
		board.placePieceAt(location, piece);
	}

	public void movePieceFromTo(String fromLocation, String toLocation) {
		Piece piece = board.getPiece(fromLocation);
		IntLocations locations = new IntLocations(fromLocation, toLocation);
		if (piece.checkMove(locations)) {
			putPieceAt(piece, toLocation);
			putPieceAt(NoPiece.noPiece(), fromLocation);
		}
		return;
	}

	public boolean checkPosition(Piece piece, String location) {
		return board.getPiece(location) == piece;
	}

}
