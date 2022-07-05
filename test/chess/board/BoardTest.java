package chess.board;

import org.junit.Test;

import chess.pieces.Pawn;
import junit.framework.TestCase;

public class BoardTest extends TestCase {

	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	@Test
	public void testCreate() {
		
		assertEquals(16, board.getNumberOfPieces());
		assertEquals(" p  p  p  p  p  p  p  p ", board.printRank(board.rank2));
		assertEquals(" P  P  P  P  P  P  P  P ", board.printRank(board.rank7));
		assertEquals(
				" .  .  .  .  .  .  .  . " + Board.NEWLINE +
				" P  P  P  P  P  P  P  P " + Board.NEWLINE +
				" .  .  .  .  .  .  .  . " + Board.NEWLINE +
				" .  .  .  .  .  .  .  . " + Board.NEWLINE +
				" .  .  .  .  .  .  .  . " + Board.NEWLINE +
				" .  .  .  .  .  .  .  . " + Board.NEWLINE +
				" p  p  p  p  p  p  p  p " + Board.NEWLINE +
				" .  .  .  .  .  .  .  . ", board.printBoard());

	}
	
}
