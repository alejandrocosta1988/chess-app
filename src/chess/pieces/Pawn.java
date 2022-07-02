package chess.pieces;

/**
 * Represents a chess pawn.
 * @author alejandro_costa
 */
public class Pawn {

	private final String WHITE = "white";
	private final String BLACK = "black";

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
