package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class PieceTest {
	
	private Piece blackPiece;
	private Piece whitePiece;
	private Piece blankPiece;
	
	@BeforeEach
	public void createSetOfPieces() {
		blackPiece = createBlackPiece();
		whitePiece = createWhitePiece();
		blankPiece = noPiece();
	}
	
	abstract Piece createBlackPiece();
	abstract Piece createWhitePiece();
	abstract Piece noPiece();
	
	@Test
	public void testGivenABlackPieceGetColorReturnsBlackColor() {
		assertEquals(Piece.Color.BLACK, blackPiece.getColor());
	}
	
	@Test
	public void testGivenAWhitePieceGetColorReturnsWhiteColor() {
		assertEquals(Piece.Color.WHITE, whitePiece.getColor());
	}
	
	@Test
	void testGivenABlackPieceIsBlackReturnsTrue() {
		assertTrue(blackPiece.isBlack());
	}
	
	@Test
	void testGivenABlackPieceIsWhiteReturnsFalse() {
		assertFalse(blackPiece.isWhite());
	}
	
	@Test
	void testGivenAWhitePieceIsWhiteReturnsTrue() {
		assertTrue(whitePiece.isWhite());
	}
	
	@Test
	void testGivenAWhitePieceIsBlackReturnsFalse() {
		assertFalse(whitePiece.isBlack());
	}
	
	@Test
	public void testGivenAPieceIsBlankReturnsFalse() {
		assertFalse(blackPiece.isBlank());
	}
	
	@Test
	public void testGivenAPieceIsNotBlankReturnsTrue() {
		assertTrue(blackPiece.isNotBlank());
	}
	
	@Test
	public void testGivenAnEmptySquareIsBlankReturnsTrue() {
		assertTrue(blankPiece.isBlank());
	}
	
	@Test
	public void testGivenAnEmptySquareIsNotBlankReturnsFalse() {
		assertFalse(blankPiece.isNotBlank());
	}
	
//	public void testEachPieceScoresDifferently() {
//		assertEquals(0d, whiteKing.getScore());
//		assertEquals(1d, blackPawn.getScore());
//		assertEquals(2.5, blackKnight.getScore());
//		assertEquals(3d, blackBishop.getScore());
//		assertEquals(5d, whiteRook.getScore());
//		assertEquals(9d, blackQueen.getScore());
//	}
	
}
