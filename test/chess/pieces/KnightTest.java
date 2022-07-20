package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KnightTest {

	private Piece blackKnight;
	private Piece whiteKnight;
	
	@BeforeEach
	void createBlackAndWhiteKnights() {
		blackKnight = Knight.createBlackKnight();
		whiteKnight = Knight.createWhiteKnight();
	}
	
	@Test
	void testGivenABlackKnightGetColorReturnsBlackColor() {
		assertTrue(blackKnight.getColor() == Piece.Color.BLACK);
	}
	
	@Test
	void testGivenAWhiteKnightGetColorReturnsWhiteColor() {
		assertTrue(whiteKnight.getColor() == Piece.Color.WHITE);
	}
	
	@Test
	void testGivenABlackKnightIsBlackReturnsTrue() {
		assertTrue(blackKnight.isBlack());
	}
	
	@Test
	void testGivenABlackKnightIsWhiteReturnsFalse() {
		assertFalse(blackKnight.isWhite());
	}
	
	@Test
	void testGivenAWhiteKnightIsWhiteReturnsTrue() {
		assertTrue(whiteKnight.isWhite());
	}
	
	@Test
	void testGivenAWhiteKnightIsBlackReturnsFalse() {
		assertFalse(whiteKnight.isBlack());
	}
	
	@Test
	void testABlackKnightShouldBeRepresentedWithAnUpperCaseNBetweenSpaces() {
		assertEquals(" N ", blackKnight.getRepresentation());
	}
	
	@Test
	void testAWhiteKnightShouldBeRepresentedWithALowerCaseNBetweenSpaces() {
		assertEquals(" n ", whiteKnight.getRepresentation());
	}
	
	@Test
	void testAKnightScoresTwoAndAHalf() {
		assertEquals(2.5, whiteKnight.getScore());
	}

}
