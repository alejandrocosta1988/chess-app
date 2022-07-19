package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class BishopTest {

	private Piece blackBishop;
	private Piece whiteBishop;
	
	@Disabled
	@BeforeEach
	void createBlackAndWhiteQueens() {
		blackBishop = Bishop.createBlackBishop();
		whiteBishop = Bishop.createWhiteBishop();
	}
	
	@Disabled
	@Test
	void testGivenABlackBishopGetColorReturnsBlackColor() {
		assertTrue(blackBishop.getColor() == Piece.Color.BLACK);
	}
	
	@Disabled
	@Test
	void testGivenAWhiteBishopGetColorReturnsWhiteColor() {
		assertTrue(whiteBishop.getColor() == Piece.Color.WHITE);
	}
	
	@Disabled
	@Test
	void testGivenABlackBishopIsBlackReturnsTrue() {
		assertTrue(blackBishop.isBlack());
	}
	
	@Disabled
	@Test
	void testGivenABlackBishopIsWhiteReturnsFalse() {
		assertFalse(blackBishop.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteBishopIsWhiteReturnsTrue() {
		assertTrue(whiteBishop.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteBishopIsBlackReturnsFalse() {
		assertFalse(whiteBishop.isBlack());
	}
	
	@Disabled
	@Test
	void testABlackBishopShouldBeRepresentedWithAnUpperCaseBBetweenSpaces() {
		assertEquals(" B ", blackBishop.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAWhiteBishopShouldBeRepresentedWithALowerCaseBBetweenSpaces() {
		assertEquals(" b ", whiteBishop.getRepresentation());
	}
	
	@Disabled
	@Test
	void testABishopScoresNine() {
		assertEquals(3d, whiteBishop.getScore());
	}

}
