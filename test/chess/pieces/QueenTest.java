package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.moves.IntLocations;

class QueenTest extends PieceTest {

	private Piece blackQueen;
	private Piece whiteQueen;
	
	@BeforeEach
	void createBlackAndWhiteQueens() {
		blackQueen = Queen.createBlackQueen();
		whiteQueen = Queen.createWhiteQueen();
	}
	
	@Override
	Piece createBlackPiece() {
		return Queen.createBlackQueen();
	}

	@Override
	Piece createWhitePiece() {
		return Queen.createWhiteQueen();
	}
	
	@Override
	Piece noPiece() {
		return NoPiece.noPiece();
	}
	
	@Test
	void testABlackQueenShouldBeRepresentedWithAnUpperCaseQBetweenSpaces() {
		assertEquals(" Q ", blackQueen.getRepresentation());
	}
	
	@Test
	void testAWhiteQueenShouldBeRepresentedWithALowerCaseQBetweenSpaces() {
		assertEquals(" q ", whiteQueen.getRepresentation());
	}
	
	@Test
	void testAQueenScoresNine() {
		assertEquals(9d, whiteQueen.getScore());
	}

	@Test
	void testWhenAQueenTriesToMoveForwardsInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "d7");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveBackwardsInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "d1");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveTowardsRightInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "g3");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveTowardsLeftInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "a3");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveForwardsAndToTheRightInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "h7");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveForwardsAndToTheLeftInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("g2", "b7");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveBackwardsAndToTheLeftInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("g7", "b2");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveBackwardsAndToTheRightInStraightLineThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("b7", "g2");
		assertTrue(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveBackwardsAndToTheRightNotInStraightLineThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("b7", "g3");
		assertFalse(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveBackwardsAndToTheLeftNotInStraightLineThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("g7", "b4");
		assertFalse(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveForwardsAndToTheLeftNotInStraightLineThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("f1", "b3");
		assertFalse(whiteQueen.checkMove(locations));
	}
	
	@Test
	void testWhenAQueenTriesToMoveForwardsAndToTheRightNotInStraightLineThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d1", "h3");
		assertFalse(whiteQueen.checkMove(locations));
	}
	
}
