package chess.pieces;

/**
 * Represents a chess piece.
 * @author alejandro_costa
 */
public class Piece {
	
	static int whitePiecesCounter = 0;
	static int blackPiecesCounter = 0;

	enum Color { WHITE, BLACK };
	enum Type { PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, NO_PIECE };
	
	private char printableRepresentation;

	private Color color;
	private Type type;
	
	private Piece(Color color, Type type) {
		this.color = color;
		incrementPieceCount();
		this.type = type;
		setPrintableRepresentation();
	}
	
	private Piece() {
		this.type = Type.NO_PIECE;
		this.printableRepresentation = '.';
	}
	
	private void incrementPieceCount() {
		if (isWhite()) {
			++Piece.whitePiecesCounter;
			return;
		}
		++Piece.blackPiecesCounter;
	}
	
	private void setPrintableRepresentation() {
		int stringIndex = defineIndex();
		definePrintableRepresentation(stringIndex);
	}
	
	private int defineIndex() {
		int stringIndex = 0;
		if (isKnight()) {
			++stringIndex;
		}
		return stringIndex;
	}
	
	private boolean isKnight() {
		return type == Type.KNIGHT;
	}
	
	private void definePrintableRepresentation(int stringIndex) {
		if (this.isBlack()) {
			representBlackPiece(stringIndex);
			return;
		}
		representWhitePiece(stringIndex);
	}
	
	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}
	
	private void representBlackPiece(int stringIndex) {
		printableRepresentation = type.toString().toUpperCase().charAt(stringIndex);
	}
	
	private void representWhitePiece(int stringIndex) {
		printableRepresentation = type.toString().toLowerCase().charAt(stringIndex);
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
	
	public static Piece noPiece() {
		return new Piece();
	}
	
	public static Piece createWhitePawn() {
		return new Piece(Color.WHITE, Type.PAWN);
	}
	
	public static Piece createBlackPawn() {
		return new Piece(Color.BLACK, Type.PAWN);
	}
	
	public static Piece createWhiteKnight() {
		return new Piece(Color.WHITE, Type.KNIGHT);
	}
	
	public static Piece createBlackKnight() {
		return new Piece(Color.BLACK, Type.KNIGHT);
	}
	
	public static Piece createWhiteRook() {
		return new Piece(Color.WHITE, Type.ROOK);
	}
	
	public static Piece createBlackRook() {
		return new Piece(Color.BLACK, Type.ROOK);
	}
	
	public static Piece createWhiteBishop() {
		return new Piece(Color.WHITE, Type.BISHOP);
	}
	
	public static Piece createBlackBishop() {
		return new Piece(Color.BLACK, Type.BISHOP);
	}
	
	public static Piece createWhiteQueen() {
		return new Piece(Color.WHITE, Type.QUEEN);
	}
	
	public static Piece createBlackQueen() {
		return new Piece(Color.BLACK, Type.QUEEN);
	}
	
	public static Piece createWhiteKing() {
		return new Piece(Color.WHITE, Type.KING);
	}
	
	public static Piece createBlackKing() {
		return new Piece(Color.BLACK, Type.KING);
	}
	
	public boolean isWhite() {
		return color.equals(Color.WHITE);
	}

	public Type getType() {
		return type;
	}

	public String getRepresentation() {
		return " " + printableRepresentation + " ";
	}

}
