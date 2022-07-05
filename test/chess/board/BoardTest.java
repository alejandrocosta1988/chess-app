package chess.board;

import org.junit.Test;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

public class BoardTest extends TestCase {

	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	@Test
	public void testCreate() {
		
		assertEquals(32, board.getNumberOfPieces());
		assertEquals(" p  p  p  p  p  p  p  p ", board.printRank(board.rank2));
		assertEquals(" P  P  P  P  P  P  P  P ", board.printRank(board.rank7));
		assertEquals(
				" R  N  B  Q  K  B  N  R " + StringUtil.addNewLine() +
				" P  P  P  P  P  P  P  P " + StringUtil.addNewLine() +
				" .  .  .  .  .  .  .  . " + StringUtil.addNewLine() +
				" .  .  .  .  .  .  .  . " + StringUtil.addNewLine() +
				" .  .  .  .  .  .  .  . " + StringUtil.addNewLine() +
				" .  .  .  .  .  .  .  . " + StringUtil.addNewLine() +
				" p  p  p  p  p  p  p  p " + StringUtil.addNewLine() +
				" r  n  b  q  k  b  n  r ", board.printBoard());
		
	}
	
}
