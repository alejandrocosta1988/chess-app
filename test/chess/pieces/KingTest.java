package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
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
	void testCheckMoveShouldReturnFalseIfDestinationIsFartherThanOneRankFromOrigin() {
		assertFalse(whiteKing.checkMove(4, 4, 4, 6));
	}

}
