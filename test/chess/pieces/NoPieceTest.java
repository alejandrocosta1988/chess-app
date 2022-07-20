package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NoPieceTest {

	private Piece blank;
	
	@Disabled
	@BeforeEach
	void createBlankPiece() {
		blank = NoPiece.noPiece();
	}
	
	@Disabled
	@Test
	public void testGivenAnEmptySquareGetRepresentationReturnsADotBetweenSpaces() {
		assertEquals(" . ", blank.getRepresentation());
	}

}
