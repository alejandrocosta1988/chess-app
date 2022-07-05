package chess.pieces;

/**
 * Represents a chess piece.
 * @author alejandro_costa
 */
public class Piece {

	public static final String WHITE = "white";
	public static final String BLACK = "black";
	
	private char printableRepresentation;

	private String color;
	private String name;
	
	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
		setPrintableRepresentation();
	}
	
	public static Piece createWhitePawn() {
		return new Piece(WHITE, "Pawn");
	}
	
	public static Piece createBlackPawn() {
		return new Piece(BLACK, "Pawn");
	}
	
	private void setPrintableRepresentation() {
		if (this.color.equals(BLACK)) {
			this.printableRepresentation = 'P';
			return;
		} 
		this.printableRepresentation = 'p';
	}

	public String getColor() {
		return color;
	}
	
	public String toString() {
		return " " + this.printableRepresentation + " ";
	}

}
