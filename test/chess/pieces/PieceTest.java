package chess.pieces;

public class PieceTest extends junit.framework.TestCase {
	
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
	
	public void setUp() {
		
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
		
	}
	
	public void testEachPieceHasItsOwnPrintableRepresentation() {
		
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
		
		assertTrue(whiteKing.isWhite());
		assertFalse(blackQueen.isWhite());
		
		assertFalse(whiteKing.isBlack());
		assertTrue(blackQueen.isBlack());
		
	}
}
