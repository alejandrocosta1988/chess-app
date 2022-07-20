package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenTest extends PieceTest {

	private Piece blackQueen;
	private Piece whiteQueen;
	
	@BeforeEach
	void createBlackAndWhiteQueens() {
		blackQueen = Queen.createBlackQueen();
		whiteQueen = Queen.createWhiteQueen();
	}
	
	@Override
	Piece createBlackPiece() {
		return Queen.createBlackQueen();
	}

	@Override
	Piece createWhitePiece() {
		return Queen.createWhiteQueen();
	}
	
	@Override
	Piece noPiece() {
		return NoPiece.noPiece();
	}
	
	@Test
	void testABlackQueenShouldBeRepresentedWithAnUpperCaseQBetweenSpaces() {
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
