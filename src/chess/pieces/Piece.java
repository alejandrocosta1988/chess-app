package chess.pieces;

/**
 * Represents a chess piece.
 * @author alejandro_costa
 */
public class Piece {
	
	static int whitePiecesCounter = 0;
	static int blackPiecesCounter = 0;

	public static final String WHITE = "white";
	public static final String BLACK = "black";
	public static final String PAWN	= "pawn";
	public static final String KNIGHT = "knight";
	public static final String ROOK = "rook";
	public static final String BISHOP = "bishop";
	public static final String 	QUEEN = "queen";
	public static final String KING = "king";
	
	private char printableRepresentation;

	private String color;
	private String name;
	
	private Piece(String color, String name) {
		incrementPieceCount(color);
		this.color = color;
		this.name = name;
		setPrintableRepresentation(name);
	}
	
	private void incrementPieceCount(String color) {
		if (color.equals(WHITE)) {
			++Piece.whitePiecesCounter;
			return;
		}
		++Piece.blackPiecesCounter;
	}
	
	private void setPrintableRepresentation(String pieceName) {
		
		int stringIndex = defineIndex(pieceName);
		definePrintableRepresentation(stringIndex);
		
	}
	
	private int defineIndex(String pieceName) {
		int stringIndex = 0;
		if (isKnight(pieceName)) {
			++stringIndex;
		}
		return stringIndex;
	}
	
	private boolean isKnight(String pieceName) {
		return pieceName.equals(KNIGHT);
	}
	
	private void definePrintableRepresentation(int stringIndex) {
		if (this.isBlack()) {
			representBlackPiece(stringIndex);
			return;
		}
		representWhitePiece(stringIndex);
	}
	
	public boolean isBlack() {
		return color.equals(BLACK);
	}
	
	private void representBlackPiece(int stringIndex) {
		printableRepresentation = name.toUpperCase().charAt(stringIndex);
	}
	
	private void representWhitePiece(int stringIndex) {
		printableRepresentation = name.toLowerCase().charAt(stringIndex);
	}
	
	static public void resetPieceCounter() {
		Piece.whitePiecesCounter = 0;
		Piece.blackPiecesCounter = 0;
	}
	
	static public int countWhitePieces() {
		return Piece.whitePiecesCounter;
	}
	
	static public int countBlackPieces() {
		return Piece.blackPiecesCounter;
	}
	
	public static Piece createWhitePawn() {
		return new Piece(WHITE, PAWN);
	}
	
	public static Piece createBlackPawn() {
		return new Piece(BLACK, PAWN);
	}
	
	public static Piece createWhiteKnight() {
		return new Piece(WHITE, KNIGHT);
	}
	
	public static Piece createBlackKnight() {
		return new Piece(BLACK, KNIGHT);
	}
	
	public static Piece createWhiteRook() {
		return new Piece(WHITE, ROOK);
	}
	
	public static Piece createBlackRook() {
		return new Piece(BLACK, ROOK);
	}
	
	public static Piece createWhiteBishop() {
		return new Piece(WHITE, BISHOP);
	}
	
	public static Piece createBlackBishop() {
		return new Piece(BLACK, BISHOP);
	}
	
	public static Piece createWhiteQueen() {
		return new Piece(WHITE, QUEEN);
	}
	
	public static Piece createBlackQueen() {
		return new Piece(BLACK, QUEEN);
	}
	
	public static Piece createWhiteKing() {
		return new Piece(WHITE, KING);
	}
	
	public static Piece createBlackKing() {
		return new Piece(BLACK, KING);
	}
	
	public String toString() {
		return " " + this.printableRepresentation + " ";
	}

	public boolean isWhite() {
		return color.equals(WHITE);
	}

}
