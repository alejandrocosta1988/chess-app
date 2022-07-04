package chess.pieces;

/**
 * Represents a chess pawn.
 * @author alejandro_costa
 */
public class Pawn {

	public static final String WHITE = "white";
	public static final String BLACK = "black";
	
	private char printableRepresentation;

	private String color;
	
	public Pawn() {
		this.color = WHITE;
		setPrintableRepresentation();
	}
	
	public Pawn(String color) {
		this.color = color;
		setPrintableRepresentation();
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
