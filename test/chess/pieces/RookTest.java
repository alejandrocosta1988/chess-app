package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RookTest {

	private Piece blackRook;
	private Piece whiteRook;
	
	@BeforeEach
	void createBlackAndWhiteRooks() {
		blackRook = Rook.createBlackRook();
		whiteRook = Rook.createWhiteRook();
	}
	
	@Test
	void testGivenABlackRookGetColorReturnsBlackColor() {
		assertTrue(blackRook.getColor() == Piece.Color.BLACK);
	}
	
	@Test
	void testGivenAWhiteRookGetColorReturnsWhiteColor() {
		assertTrue(whiteRook.getColor() == Piece.Color.WHITE);
	}
	
	@Test
	void testGivenABlackRookIsBlackReturnsTrue() {
		assertTrue(blackRook.isBlack());
	}
	
	@Test
	void testGivenABlackRookIsWhiteReturnsFalse() {
		assertFalse(blackRook.isWhite());
	}
	
	@Test
	void testGivenAWhiteRookIsWhiteReturnsTrue() {
		assertTrue(whiteRook.isWhite());
	}
	
	@Test
	void testGivenAWhiteRookIsBlackReturnsFalse() {
		assertFalse(whiteRook.isBlack());
	}
	
	@Test
	void testABlackRookShouldBeRepresentedWithAnUpperCaseRBetweenSpaces() {
		assertEquals(" R ", blackRook.getRepresentation());
	}
	
	@Test
	void testAWhiteRookShouldBeRepresentedWithALowerCaseRBetweenSpaces() {
		assertEquals(" r ", whiteRook.getRepresentation());
	}
	
	@Test
	void testARookScoresNine() {
		assertEquals(5d, whiteRook.getScore());
	}

}
