package chess.pieces;

public class Bishop extends Piece {

	private Bishop(Piece.Color color) {
		super(color);
		setPrintableRepresentation('b');
		setScore(3d);
	}
	
	public static Piece createBlackBishop() {
		return new Bishop(Piece.Color.BLACK);
	}

	public static Piece createWhiteBishop() {
		return new Bishop(Piece.Color.WHITE);
	}
	
	private void setPrintableRepresentation(char representation) {
		printableRepresentation = representation;
	}
	
	private void setScore(double score) {
		this.score = score;
	}

}
