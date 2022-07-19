package chess.pieces;

public class Queen extends Piece {
	
	private double score = 9.0;
	private char printableRepresentation = 'q';
	
	private Queen(Piece.Color color) {
		super(color);
	}
	
	public static Piece createBlackQueen() {
		return new Queen(Piece.Color.BLACK);
	}
	
	public static Piece createWhiteQueen() {
		return new Queen(Piece.Color.WHITE);
	}
	
	public double getScore() {
		return score;
	}
	
	public String getRepresentation() {
		if (isBlack()) {
			return representBlackQueen();
		}
		return representWhiteQueen();
	}
	
	private String representBlackQueen() {
		return " " + Character.toUpperCase(printableRepresentation) + " ";
	}
	
	private String representWhiteQueen() {
		return " " + printableRepresentation + " ";
	}
}
