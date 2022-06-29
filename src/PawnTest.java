
public class PawnTest extends junit.framework.TestCase {

	public void testCreate() {
		
		final String white = "white";
		final String black = "black";
		
		Pawn whitePawn = new Pawn(white);
		Pawn blackPawn = new Pawn(black);
		
		assertEquals(white, whitePawn.getColor());
		assertEquals(black, blackPawn.getColor());
		
	}
}
