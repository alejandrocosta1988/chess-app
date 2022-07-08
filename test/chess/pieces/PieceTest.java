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
	private Piece blank;
	
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
		blank = Piece.noPiece();
	}
	
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
	
	public void testPiecesCanBeBlackOrWhite() {
		assertTrue(whiteKing.isWhite());
		assertFalse(blackQueen.isWhite());
		assertFalse(whiteKing.isBlack());
		assertTrue(blackQueen.isBlack());
	}
	
	public void testPiecesType() {
		assertEquals(Piece.Type.PAWN, blackPawn.getType());
		assertEquals(Piece.Type.ROOK, blackRook.getType());
		assertEquals(Piece.Type.KNIGHT, blackKnight.getType());
		assertEquals(Piece.Type.BISHOP, blackBishop.getType());
		assertEquals(Piece.Type.QUEEN, blackQueen.getType());
		assertEquals(Piece.Type.KING, blackKing.getType());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}
	
	public void testChecksIfAPiceIsBlank() {
		assertTrue(blank.isBlank());
		assertFalse(whitePawn.isBlank());
	}
}
