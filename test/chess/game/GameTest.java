package chess.game;

import org.junit.Test;

import chess.board.Board;
import chess.pieces.Piece;
import junit.framework.TestCase;

public class GameTest extends TestCase {

	private Board kingBoard;
	
	@Override
	public void setUp() {
		kingBoard = new Board();
		kingBoard.placePieceAt("d4", Piece.createBlackKing());
	}
	
	@Test
	public void testCreateGame() {
		Game game = new Game(kingBoard);
		assertNotNull("The board in game cannot be null", game.getBoard());
	}
	
}
