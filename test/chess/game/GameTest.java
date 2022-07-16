package chess.game;

import org.junit.Test;

import chess.board.Board;
import chess.pieces.Piece;
import junit.framework.TestCase;

public class GameTest extends TestCase {

	@Test
	public void testCreateGame() {
		Board board = new Board();
		board.placePieceAt("d4", Piece.createWhiteKing());
		Game game = new Game(board);
		assertNotNull("The board in game cannot be null", game.getBoard());
	}
	
}
