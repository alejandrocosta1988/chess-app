package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NoPieceTest {

	private Piece blank;
	
	@BeforeEach
	void createBlankPiece() {
		blank = NoPiece.createNoPiece();
	}
	
	@Disabled
	@Test
	public void testGivenAnEmptySquareIsBlankReturnsTrue() {
		assertTrue(blank.isBlank());
	}
	
	@Disabled
	@Test
	public void testGivenAnEmptySquareIsNotBlankReturnsFalse() {
		assertFalse(blank.isNotBlank());
	}
	
	@Disabled
	@Test
	public void testGivenAnEmptySquareGetRepresentationReturnsADotBetweenSpaces() {
		assertEquals(" . ", blank.getRepresentation());
	}

}
