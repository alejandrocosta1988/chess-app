package chess.board;

import org.junit.Test;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

public class BoardTest extends TestCase {

	final String EMPTY_RANK = " .  .  .  .  .  .  .  . ";
	final String RANK_1 = " r  n  b  q  k  b  n  r ";
	final String RANK_2 = " p ".repeat(8);
	final String RANK_7 = RANK_2.toUpperCase();
	final String RANK_8 = RANK_1.toUpperCase();
	
	private Board board;
	
	public void setUp() {
		Piece.resetPieceCounter();
		board = new Board();
	}
	
	@Test
	public void testCreate() {
		
		assertEquals(32, board.getNumberOfPieces());
		assertEquals(" p  p  p  p  p  p  p  p ", board.printRank(board.rank2));
		assertEquals(" P  P  P  P  P  P  P  P ", board.printRank(board.rank7));
		assertEquals(
				RANK_8 + StringUtil.addNewLine() +
				RANK_7 + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				RANK_2 + StringUtil.addNewLine() +
				RANK_1, board.printBoard());
		
	}
	
	@Test
	public void testABoardCreates16BlackAnd16WhitePieces() {
		
		assertEquals(16, Piece.countWhitePieces());
		assertEquals(16, Piece.countBlackPieces());
		
	}
	
}
