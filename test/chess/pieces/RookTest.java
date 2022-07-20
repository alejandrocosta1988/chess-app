package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class RookTest {

	private Piece blackRook;
	private Piece whiteRook;
	
	@Disabled
	@BeforeEach
	void createBlackAndWhiteRooks() {
		blackRook = Rook.createBlackRook();
		whiteRook = Rook.createWhiteRook();
	}
	
	@Disabled
	@Test
	void testGivenABlackRookGetColorReturnsBlackColor() {
		assertTrue(blackRook.getColor() == Piece.Color.BLACK);
	}
	
	@Disabled
	@Test
	void testGivenAWhiteRookGetColorReturnsWhiteColor() {
		assertTrue(whiteRook.getColor() == Piece.Color.WHITE);
	}
	
	@Disabled
	@Test
	void testGivenABlackRookIsBlackReturnsTrue() {
		assertTrue(blackRook.isBlack());
	}
	
	@Disabled
	@Test
	void testGivenABlackRookIsWhiteReturnsFalse() {
		assertFalse(blackRook.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteRookIsWhiteReturnsTrue() {
		assertTrue(whiteRook.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhiteRookIsBlackReturnsFalse() {
		assertFalse(whiteRook.isBlack());
	}
	
	@Disabled
	@Test
	void testABlackRookShouldBeRepresentedWithAnUpperCaseBBetweenSpaces() {
		assertEquals(" B ", blackRook.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAWhiteRookShouldBeRepresentedWithALowerCaseBBetweenSpaces() {
		assertEquals(" b ", whiteRook.getRepresentation());
	}
	
	@Disabled
	@Test
	void testARookScoresNine() {
		assertEquals(3d, whiteRook.getScore());
	}

}
