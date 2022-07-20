package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class PieceTest {
	
	private Piece blackPiece;
	private Piece whitePiece;
	
	@BeforeEach
	public void createSetOfPieces() {
		blackPiece = createBlackPiece();
		whitePiece = createWhitePiece();
	}
	
	abstract Piece createBlackPiece();
	abstract Piece createWhitePiece();
	
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
	public void testChecksIfAPieceIsBlankOrNot() {
		assertTrue(blank.isBlank());
		assertFalse(whitePawn.isBlank());
		assertTrue(whitePawn.isNotBlank());
		assertFalse(blank.isNotBlank());
	}
	
	@Test
	public void testEachPieceScoresDifferently() {
//		assertEquals(0d, whiteKing.getScore());
		assertEquals(1d, blackPawn.getScore());
		assertEquals(2.5, blackKnight.getScore());
		assertEquals(3d, blackBishop.getScore());
		assertEquals(5d, whiteRook.getScore());
//		assertEquals(9d, blackQueen.getScore());
	}
	
}
