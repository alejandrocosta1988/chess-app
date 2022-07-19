package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class KnightTest {

	private Piece blackKnight;
	private Piece whiteKnight;
	
	@Disabled
	@BeforeEach
	void createBlackAndWhiteKnights() {
		blackKnight = Knight.createBlackKnight();
		whiteKnight = Knight.createWhiteKnight();
	}
	
	@Disabled
	@Test
	void testGivenABlackKnightGetColorReturnsBlackColor() {
		assertTrue(blackKnight.getColor() == Piece.Color.BLACK);
	}
	
	@Disabled
	@Test
	void testGivenAWhiteKnightGetColorReturnsWhiteColor() {
		assertTrue(whiteKnight.getColor() == Piece.Color.WHITE);
	}
	
	@Disabled
	@Test
	void testGivenABlackKnightIsBlackReturnsTrue() {
		assertTrue(blackKnight.isBlack());
	}
	
	@Disabled
	@Test
	void testGivenABlackKnightIsWhiteReturnsFalse() {
		assertFalse(blackKnight.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteKnightIsWhiteReturnsTrue() {
		assertTrue(whiteKnight.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteKnightIsBlackReturnsFalse() {
		assertFalse(whiteKnight.isBlack());
	}
	
	@Disabled
	@Test
	void testABlackKnightShouldBeRepresentedWithAnUpperCaseNBetweenSpaces() {
		assertEquals(" N ", blackKnight.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAWhiteKnightShouldBeRepresentedWithALowerCaseNBetweenSpaces() {
		assertEquals(" n ", whiteKnight.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAKnightScoresTwoAndAHalf() {
		assertEquals(2.5, whiteKnight.getScore());
	}

}
