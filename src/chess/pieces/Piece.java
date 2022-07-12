package chess.pieces;

/**
 * Represents a chess piece.
 * @author alejandro_costa
 */
public class Piece {
	
	public enum Color { WHITE, BLACK };
	public enum Type { PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, NO_PIECE };
	
	private char printableRepresentation;

	private Color color;
	private Type type;
	
	private Score score = new ScoreImplementation();
	private double strength;
	
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		setPrintableRepresentation();
	}
	
	private Piece() {
		this.type = Type.NO_PIECE;
		this.printableRepresentation = '.';
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
		return color == Color.BLACK;
	}
	
	private void representBlackPiece(int stringIndex) {
		printableRepresentation = type.toString().toUpperCase().charAt(stringIndex);
	}
	
	private void representWhitePiece(int stringIndex) {
		printableRepresentation = type.toString().toLowerCase().charAt(stringIndex);
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
		return color == Color.WHITE;
	}

	public Type getType() {
		return type;
	}

	public String getRepresentation() {
		return " " + printableRepresentation + " ";
	}

	public boolean isBlank() {
		return type == Type.NO_PIECE;
	}

	public boolean isNotBlank() {
		return type != Type.NO_PIECE;
	}

	public Color getColor() {
		return color;
	}

	public double getScore() {
		return score.calculateScore(type);
	}
	
	public double getHalfPawnScore() {
		return score.calculateHalfPawnScore();
	}
	
	public boolean isPawn() {
		return type == Type.PAWN;
	}
	
	public boolean isColor(Color color) {
		return this.color == color;
	}
	
	public void setStrength() {
		strength = getScore();
	}

	public double getStrength() {
		return strength;
	}
	
}
