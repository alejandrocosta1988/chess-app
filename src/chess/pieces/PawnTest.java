package chess.pieces;

public class PawnTest extends junit.framework.TestCase {

	public void testCreate() {
		
		Pawn whitePawn01 = new Pawn(Pawn.WHITE);
		Pawn blackPawn01 = new Pawn(Pawn.BLACK);
		Pawn whitePawn02 = new Pawn();
		
		assertEquals(Pawn.WHITE, whitePawn01.getColor());
		assertEquals(Pawn.BLACK, blackPawn01.getColor());
		assertEquals(Pawn.WHITE, whitePawn02.getColor());
		
	}
}
