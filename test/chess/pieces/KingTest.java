package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
	void testWhenAKingTriesToMoveMoreThanOneRankForwardsThenCheckMoveReturnsFalse() {
		assertFalse(whiteKing.checkMove(4, 4, 4, 6));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneRankBackwardsThenCheckMoveReturnsFalse() {
		assertFalse(whiteKing.checkMove(4, 4, 4, 2));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsRightThenCheckMoveReturnsFalse() {
		assertFalse(whiteKing.checkMove(4, 4, 6, 4));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsLeftThenCheckMoveReturnsFalse() {
		assertFalse(whiteKing.checkMove(4, 4, 2, 4));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneFileFromOriginThenCheckMoveReturnsTrue() {
		assertTrue(whiteKing.checkMove(4, 4, 5, 4));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneRankFromOriginThenCheckMoveReturnsTrue() {
		assertTrue(whiteKing.checkMove(4, 4, 4, 5));
	}

}
