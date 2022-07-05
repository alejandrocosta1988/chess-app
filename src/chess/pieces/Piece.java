package chess.pieces;

/**
 * Represents a chess piece.
 * @author alejandro_costa
 */
public class Piece {

	public static final String WHITE = "white";
	public static final String BLACK = "black";
	public static final String PAWN	= "pawn";
	
	private char printableRepresentation;

	private String color;
	private String name;
	
	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
		setPrintableRepresentation(name);
	}
	
	private void setPrintableRepresentation(String pieceName) {
		if (this.color.equals(BLACK)) {
			this.printableRepresentation = pieceName.toUpperCase().charAt(0);
			return;
		} 
		this.printableRepresentation = pieceName.toLowerCase().charAt(0);
	}
	
	public static Piece createWhitePawn() {
		return new Piece(WHITE, PAWN);
	}
	
	public static Piece createBlackPawn() {
		return new Piece(BLACK, PAWN);
	}
	

	public String getColor() {
		return color;
	}
	
	public String toString() {
		return " " + this.printableRepresentation + " ";
	}

}
