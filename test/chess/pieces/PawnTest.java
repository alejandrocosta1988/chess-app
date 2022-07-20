package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PawnTest {

	private Piece blackPawn;
	private Piece whitePawn;
	
	@BeforeEach
	void createBlackAndWhitePawns() {
		blackPawn = Pawn.createBlackPawn();
		whitePawn = Pawn.createWhitePawn();
	}
	
	@Test
	void testGivenABlackPawnGetColorReturnsBlackColor() {
		assertTrue(blackPawn.getColor() == Piece.Color.BLACK);
	}
	
	@Test
	void testGivenAWhitePawnGetColorReturnsWhiteColor() {
		assertTrue(whitePawn.getColor() == Piece.Color.WHITE);
	}
	
	@Test
	void testGivenABlackPawnIsBlackReturnsTrue() {
		assertTrue(blackPawn.isBlack());
	}
	
	@Test
	void testGivenABlackPawnIsWhiteReturnsFalse() {
		assertFalse(blackPawn.isWhite());
	}
	
	@Test
	void testGivenAWhitePawnIsWhiteReturnsTrue() {
		assertTrue(whitePawn.isWhite());
	}
	
	@Test
	void testGivenAWhitePawnIsBlackReturnsFalse() {
		assertFalse(whitePawn.isBlack());
	}
	
	@Test
	void testABlackPawnShouldBeRepresentedWithAnUpperCasePBetweenSpaces() {
		assertEquals(" P ", blackPawn.getRepresentation());
	}
	
	@Test
	void testAWhitePawnShouldBeRepresentedWithALowerCasePBetweenSpaces() {
		assertEquals(" p ", whitePawn.getRepresentation());
	}
	
	@Test
	void testAPawnScoresOne() {
		assertEquals(1d, whitePawn.getScore());
	}
	
	@Test
	void testAPawnMayScoreHalfAPoint() {
		assertEquals(0.5, whitePawn.getHalfScore());
	}

}
