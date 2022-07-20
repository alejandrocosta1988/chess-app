package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoPieceTest {

	private Piece blank;
	
	@BeforeEach
	void createBlankPiece() {
		blank = NoPiece.noPiece();
	}
	
	@Test
	public void testGivenAnEmptySquareGetRepresentationReturnsADotBetweenSpaces() {
		assertEquals(" . ", blank.getRepresentation());
	}

}
