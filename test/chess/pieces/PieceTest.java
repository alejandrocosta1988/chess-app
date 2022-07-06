package chess.pieces;

public class PieceTest extends junit.framework.TestCase {
	
	public void testEachPieceHasItsOwnPrintableRepresentation() {
		
		Piece blackPawn = Piece.createBlackPawn();
		Piece whitePawn = Piece.createWhitePawn();
		Piece blackKnight = Piece.createBlackKnight();
		Piece whiteKnight = Piece.createWhiteKnight();
		Piece blackRook = Piece.createBlackRook();
		Piece whiteRook = Piece.createWhiteRook();
		Piece blackBishop = Piece.createBlackBishop();
		Piece whiteBishop = Piece.createWhiteBishop();
		Piece blackQueen = Piece.createBlackQueen();
		Piece whiteQueen = Piece.createWhiteQueen();
		Piece blackKing = Piece.createBlackKing();
		Piece whiteKing = Piece.createWhiteKing();
		
		assertEquals(" P ", blackPawn.toString());
		assertEquals(" p ", whitePawn.toString());
		assertEquals(" N ", blackKnight.toString());
		assertEquals(" n ", whiteKnight.toString());
		assertEquals(" R ", blackRook.toString());
		assertEquals(" r ", whiteRook.toString());
		assertEquals(" B ", blackBishop.toString());
		assertEquals(" b ", whiteBishop.toString());
		assertEquals(" Q ", blackQueen.toString());
		assertEquals(" q ", whiteQueen.toString());
		assertEquals(" K ", blackKing.toString());
		assertEquals(" k ", whiteKing.toString());
		
	}
	
	public void testPiecesCanBeBlackOrWhite() {
		
		Piece whiteKing = Piece.createWhiteKing();
		Piece blackQueen = Piece.createBlackQueen();
		
		assertTrue(whiteKing.isWhite());
		assertFalse(blackQueen.isWhite());
		
		assertFalse(whiteKing.isBlack());
		assertTrue(blackQueen.isBlack());
		
	}
}
