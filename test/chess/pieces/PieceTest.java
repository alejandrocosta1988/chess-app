package chess.pieces;

public class PieceTest extends junit.framework.TestCase {

	public void testCreate() {
		
		Piece whitePawn01 = new Piece(Piece.WHITE);
		Piece blackPawn01 = new Piece(Piece.BLACK);
		Piece whitePawn02 = new Piece();
		
		assertEquals(Piece.WHITE, whitePawn01.getColor());
		assertEquals(Piece.BLACK, blackPawn01.getColor());
		assertEquals(Piece.WHITE, whitePawn02.getColor());
		
	}
	
	public void testPrintableRepresentation() {
		
		Piece blackPawn = new Piece(Piece.BLACK);
		Piece whitePawn = new Piece();
		
		assertEquals(" P ", blackPawn.toString());
		assertEquals(" p ", whitePawn.toString());
		
	}
}
