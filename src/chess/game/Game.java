package chess.game;

import chess.board.Board;

public class Game {

	private Board board;
	
	public Game(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}

}
