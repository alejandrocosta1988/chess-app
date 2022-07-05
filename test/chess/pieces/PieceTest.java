package chess.pieces;

public class PieceTest extends junit.framework.TestCase {

	public void testCreate() {
		
		Piece whitePawn01 = Piece.createWhitePawn();
		Piece blackPawn01 = Piece.createBlackPawn();
		Piece whitePawn02 = Piece.createWhitePawn();
		
		assertEquals(Piece.WHITE, whitePawn01.getColor());
		assertEquals(Piece.BLACK, blackPawn01.getColor());
		assertEquals(Piece.WHITE, whitePawn02.getColor());
		
	}
	
	public void testPrintableRepresentation() {
		
		Piece blackPawn = Piece.createBlackPawn();
		Piece whitePawn = Piece.createWhitePawn();
		
		assertEquals(" P ", blackPawn.toString());
		assertEquals(" p ", whitePawn.toString());
		
	}
}
