package chess.pieces;

/**
 * Represents a chess pawn.
 * @author alejandro_costa
 */
public class Pawn {

	public static final String WHITE = "white";
	public static final String BLACK = "black";

	private String color;
	
	public Pawn() {
		this.color = WHITE;
	}
	
	public Pawn(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}
