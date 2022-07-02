package chess.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testCreate() {
		
		Board board = new Board();
		
		assertEquals(0, board.getNumberOfPieces());

	}

}
