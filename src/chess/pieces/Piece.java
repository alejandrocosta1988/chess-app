package chess.pieces;

public class Piece implements Comparable<Piece> {
	
	public enum Color { WHITE, BLACK };
	public enum Type { 
	
		PAWN(1.0, 'p'), 
		KNIGHT(2.5, 'n'), 
		ROOK(5.0, 'r'), 
		BISHOP(3.0, 'b'), 
		QUEEN(9.0, 'q'), 
		NO_PIECE(0.0, '.');
		
		private double score;
		private char printableRepresentation;
		
		Type(double score, char printableRepresentation) {
			this.score = score;
			this.printableRepresentation = printableRepresentation;
		}
		
		double getScore() {
			return score;
		}
		
		String getPrintableRepresentation() {
			return " " + printableRepresentation + " ";
		}
		
	};
	
	private Color color;
	private Type type;
	
	private double strength;
	
	protected Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}
	
	protected Piece(Color color) {
		this.color = color;
	}
	
	protected Piece() {
		this.type = Type.NO_PIECE;
	}
	
	public boolean isBlack() {
		return color == Color.BLACK;
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
	
	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public Type getType() {
		return type;
	}

	public String getRepresentation() {
		if (color == Color.BLACK) {
			return type.getPrintableRepresentation().toUpperCase();
		}
		return type.getPrintableRepresentation();
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
		return type.getScore();
	}
	
	public double getHalfPawnScore() {
		return type.getScore() / 2;
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

	@Override
	public int compareTo(Piece that) {
		return Double.compare(that.getStrength(), this.getStrength());
	}
	
}
