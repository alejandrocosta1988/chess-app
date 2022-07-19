package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenTest {

	private Piece blackQueen;
	private Piece whiteQueen;
	
	@BeforeEach
	void createBlackAndWhiteQueens() {
		blackQueen = Queen.createBlackQueen();
		whiteQueen = Queen.createWhiteQueen();
	}
	
	@Test
	void testGivenABlackQueenGetColorReturnsBlackColor() {
		assertTrue(blackQueen.getColor() == Piece.Color.BLACK);
	}
	
	@Test
	void testGivenAWhiteQueenGetColorReturnsWhiteColor() {
		assertTrue(whiteQueen.getColor() == Piece.Color.WHITE);
	}
	
	@Test
	void testGivenABlackQueenIsBlackReturnsTrue() {
		assertTrue(blackQueen.isBlack());
	}
	
	@Test
	void testGivenABlackQueenIsWhiteReturnsFalse() {
		assertFalse(blackQueen.isWhite());
	}
	
	@Test
	void testGivenAWhiteQueenIsWhiteReturnsTrue() {
		assertTrue(whiteQueen.isWhite());
	}
	
	@Test
	void testGivenAWhiteQueenIsBlackReturnsFalse() {
		assertFalse(whiteQueen.isBlack());
	}
	
	@Test
	void testABlackQueenShouldBeRepresentedWithAUpperCaseQBetweenSpaces() {
		assertEquals(" Q ", blackQueen.getRepresentation());
	}
	
	@Test
	void testAWhiteQueenShouldBeRepresentedWithALowerCaseQBetweenSpaces() {
		assertEquals(" q ", whiteQueen.getRepresentation());
	}
	
	@Test
	void testAQueenScoresNine() {
		assertEquals(9d, whiteQueen.getScore());
	}
	
}
