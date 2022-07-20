package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BishopTest {

	private Piece blackBishop;
	private Piece whiteBishop;
	
	@BeforeEach
	void createBlackAndWhiteQueens() {
		blackBishop = Bishop.createBlackBishop();
		whiteBishop = Bishop.createWhiteBishop();
	}
	
	@Test
	void testGivenABlackBishopGetColorReturnsBlackColor() {
		assertTrue(blackBishop.getColor() == Piece.Color.BLACK);
	}
	
	@Test
	void testGivenAWhiteBishopGetColorReturnsWhiteColor() {
		assertTrue(whiteBishop.getColor() == Piece.Color.WHITE);
	}
	
	@Test
	void testGivenABlackBishopIsBlackReturnsTrue() {
		assertTrue(blackBishop.isBlack());
	}
	
	@Test
	void testGivenABlackBishopIsWhiteReturnsFalse() {
		assertFalse(blackBishop.isWhite());
	}
	
	@Test
	void testGivenAWhiteBishopIsWhiteReturnsTrue() {
		assertTrue(whiteBishop.isWhite());
	}
	
	@Test
	void testGivenAWhiteBishopIsBlackReturnsFalse() {
		assertFalse(whiteBishop.isBlack());
	}
	
	@Test
	void testABlackBishopShouldBeRepresentedWithAnUpperCaseBBetweenSpaces() {
		assertEquals(" B ", blackBishop.getRepresentation());
	}
	
	@Test
	void testAWhiteBishopShouldBeRepresentedWithALowerCaseBBetweenSpaces() {
		assertEquals(" b ", whiteBishop.getRepresentation());
	}
	
	@Test
	void testABishopScoresNine() {
		assertEquals(3d, whiteBishop.getScore());
	}

}
