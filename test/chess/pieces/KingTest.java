package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.moves.IntLocations;

class KingTest {

	private Piece whiteKing;
	private Piece blackKing;
	
	@BeforeEach
	public void createsWhiteAndBlackKings() {
		whiteKing = King.createWhiteKing();
		blackKing = King.createBlackKing();
	}
	
	@Test
	void testABlackKingsShouldReturnBlackColor() {
		assertEquals(Piece.Color.BLACK, blackKing.getColor());
	}
	
	@Test
	void testAWhiteKingsShouldReturnWhiteColor() {
		assertEquals(Piece.Color.WHITE, whiteKing.getColor());
	}
	
	@Test
	void testABlackKingShouldBeRepresentedWithAUpperCaseKBetweenSpaces() {
		assertEquals(" K ", blackKing.getRepresentation());
	}
	
	@Test
	void testAWhiteKingShouldBeRepresentedWithALowerCaseKBetweenSpaces() {
		assertEquals(" k ", whiteKing.getRepresentation());
	}
	
	@Test
	void testAKingScoresZero() {
		assertEquals(0d, whiteKing.getScore());
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneRankForwardsThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "d5");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneRankBackwardsThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "d1");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsRightThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "f3");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsLeftThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "b3");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneFileFromOriginThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "c3");
		assertTrue(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneRankFromOriginThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "d4");
		assertTrue(whiteKing.checkMove(locations));
	}
	
	

}
