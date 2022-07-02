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
		
		assertEquals(0, board.getNumberOfPieces());

	}
	
	@Test
	public void testAddPawnToBoard() {
		
		Pawn whitePawn01 = new Pawn();
		Pawn blackPawn01 = new Pawn(Pawn.BLACK);
		
		board.addPawn(whitePawn01);
		assertEquals(1, board.getNumberOfPieces());
		assertTrue(board.contains(whitePawn01));
		
		board.addPawn(blackPawn01);
		assertEquals(2, board.getNumberOfPieces());
		assertTrue(board.contains(blackPawn01));
		
	}

}
