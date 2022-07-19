package chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KingTest {

	@Test
	void testABlackKingsShouldReturnBlackColor() {
		Piece blackKing = King.createBlackKing();
		assertEquals(Piece.Color.BLACK, blackKing.getColor());
	}
	
	@Test
	void testAWhiteKingsShouldReturnWhiteColor() {
		Piece whiteKing = King.createWhiteKing();
		assertEquals(Piece.Color.WHITE, whiteKing.getColor());
	}
	
	@Test
	void testABlackKingShouldBeRepresentedWithAUpperCaseKBetweenSpaces() {
		Piece blackKing = King.createBlackKing();
		assertEquals(" K ", blackKing.getRepresentation());
	}
	
	@Test
	void testAWhiteKingShouldBeRepresentedWithALowerCaseKBetweenSpaces() {
		Piece whiteKing = King.createWhiteKing();
		assertEquals(" k ", whiteKing.getRepresentation());
	}

}
