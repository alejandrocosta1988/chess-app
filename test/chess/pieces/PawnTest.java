package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class PawnTest {

	private Piece blackPawn;
	private Piece whitePawn;
	
	@Disabled
	@BeforeEach
	void createBlackAndWhitePawns() {
		blackPawn = Pawn.createBlackPawn();
		whitePawn = Pawn.createWhitePawn();
	}
	
	@Disabled
	@Test
	void testGivenABlackPawnGetColorReturnsBlackColor() {
		assertTrue(blackPawn.getColor() == Piece.Color.BLACK);
	}
	
	@Disabled
	@Test
	void testGivenAWhitePawnGetColorReturnsWhiteColor() {
		assertTrue(whitePawn.getColor() == Piece.Color.WHITE);
	}
	
	@Disabled
	@Test
	void testGivenABlackPawnIsBlackReturnsTrue() {
		assertTrue(blackPawn.isBlack());
	}
	
	@Disabled
	@Test
	void testGivenABlackPawnIsWhiteReturnsFalse() {
		assertFalse(blackPawn.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhitePawnIsWhiteReturnsTrue() {
		assertTrue(whitePawn.isWhite());
	}
	
	@Disabled
	@Test
	void testGivenAWhitePawnIsBlackReturnsFalse() {
		assertFalse(whitePawn.isBlack());
	}
	
	@Disabled
	@Test
	void testABlackPawnShouldBeRepresentedWithAnUpperCaseBBetweenSpaces() {
		assertEquals(" B ", blackPawn.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAWhitePawnShouldBeRepresentedWithALowerCaseBBetweenSpaces() {
		assertEquals(" b ", whitePawn.getRepresentation());
	}
	
	@Disabled
	@Test
	void testAPawnScoresNine() {
		assertEquals(3d, whitePawn.getScore());
	}

}
