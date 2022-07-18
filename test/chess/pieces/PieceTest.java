package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {
	
	private Piece blackPawn;
	private Piece whitePawn;
	private Piece blackKnight;
	private Piece whiteKnight;
	private Piece blackRook;
	private Piece whiteRook;
	private Piece blackBishop;
	private Piece whiteBishop;
	private Piece blackQueen;
	private Piece whiteQueen;
	private Piece blackKing;
	private Piece whiteKing;
	private Piece blank;
	
	@BeforeEach
	public void createSetOfPieces() {
		blackPawn = Piece.createBlackPawn();
		whitePawn = Piece.createWhitePawn();
		blackKnight = Piece.createBlackKnight();
		whiteKnight = Piece.createWhiteKnight();
		blackRook = Piece.createBlackRook();
		whiteRook = Piece.createWhiteRook();
		blackBishop = Piece.createBlackBishop();
		whiteBishop = Piece.createWhiteBishop();
		blackQueen = Piece.createBlackQueen();
		whiteQueen = Piece.createWhiteQueen();
		blackKing = Piece.createBlackKing();
		whiteKing = Piece.createWhiteKing();
		blank = Piece.noPiece();
	}
	
	@Test
	public void testEachPieceHasItsOwnPrintableRepresentation() {
		assertEquals(" P ", blackPawn.getRepresentation());
		assertEquals(" p ", whitePawn.getRepresentation());
		assertEquals(" N ", blackKnight.getRepresentation());
		assertEquals(" n ", whiteKnight.getRepresentation());
		assertEquals(" R ", blackRook.getRepresentation());
		assertEquals(" r ", whiteRook.getRepresentation());
		assertEquals(" B ", blackBishop.getRepresentation());
		assertEquals(" b ", whiteBishop.getRepresentation());
		assertEquals(" Q ", blackQueen.getRepresentation());
		assertEquals(" q ", whiteQueen.getRepresentation());
		assertEquals(" K ", blackKing.getRepresentation());
		assertEquals(" k ", whiteKing.getRepresentation());
		assertEquals(" . ", blank.getRepresentation());
	}
	
	@Test
	public void testPiecesCanBeBlackOrWhite() {
		assertTrue(whiteKing.isWhite());
		assertFalse(blackQueen.isWhite());
		assertFalse(whiteKing.isBlack());
		assertTrue(blackQueen.isBlack());
	}
	
	@Test
	public void testEachPieceHasAType() {
		assertEquals(Piece.Type.PAWN, blackPawn.getType());
		assertEquals(Piece.Type.ROOK, blackRook.getType());
		assertEquals(Piece.Type.KNIGHT, blackKnight.getType());
		assertEquals(Piece.Type.BISHOP, blackBishop.getType());
		assertEquals(Piece.Type.QUEEN, blackQueen.getType());
		assertEquals(Piece.Type.KING, blackKing.getType());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
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
		assertEquals(0d, whiteKing.getScore());
		assertEquals(1d, blackPawn.getScore());
		assertEquals(2.5, blackKnight.getScore());
		assertEquals(3d, blackBishop.getScore());
		assertEquals(5d, whiteRook.getScore());
		assertEquals(9d, blackQueen.getScore());
	}
	
}
