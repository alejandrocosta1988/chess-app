package chess.pieces;

public class King extends Piece {

	private double score = 0;
	private char printableRepresentation = 'k';
	
	private King(Piece.Color color) {
		super(color);
	}
	
	public static Piece createBlackKing() {
		return new King(Piece.Color.BLACK);
	}
	
	public static Piece createWhiteKing() {
		return new King(Piece.Color.WHITE);
	}
	
	public double getScore() {
		return score;
	}
	
	public String getRepresentation() {
		if (isBlack()) {
			return representBlackKing();
		}
		return representWhiteKing();
	}
	
	private String representBlackKing() {
		return " " + Character.toUpperCase(printableRepresentation) + " ";
	}
	
	private String representWhiteKing() {
		return " " + printableRepresentation + " ";
	}
	
	public boolean checkMove(int originFile, int originRank, int destinationFile, int destinationRank) {
		return false;
	}

}
