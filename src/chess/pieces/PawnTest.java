package chess.pieces;

public class PawnTest extends junit.framework.TestCase {

	public void testCreate() {
		
		final String white = "white";
		final String black = "black";
		
		Pawn whitePawn01 = new Pawn(white);
		Pawn blackPawn01 = new Pawn(black);
		Pawn whitePawn02 = new Pawn();
		
		assertEquals(white, whitePawn01.getColor());
		assertEquals(black, blackPawn01.getColor());
		assertEquals(white, whitePawn02.getColor());
		
	}
}
