package chess.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import chess.pieces.Pawn;

public class BoardTest {

	@Test
	public void testCreate() {
		
		Board board = new Board();
		
		assertEquals(0, board.getNumberOfPieces());

	}
	
	@Test
	public void testAddPawnToBoard() {
		
		final String BLACK = "black";
		Board board = new Board();
		ArrayList<Pawn> pieces = board.getPieces();
		Pawn whitePawn01 = new Pawn();
		Pawn blackPawn01 = new Pawn(BLACK);
		
		board.addPawn(whitePawn01);
		assertEquals(1, board.getNumberOfPieces());
		assertTrue(pieces.contains(whitePawn01));
		
		board.addPawn(blackPawn01);
		assertEquals(2, board.getNumberOfPieces());
		assertTrue(pieces.contains(blackPawn01));
		
	}

}
