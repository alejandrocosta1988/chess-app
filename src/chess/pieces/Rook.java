package chess.pieces;

public class Rook extends Piece {

	private Rook(Piece.Color color) {
		super(color);
		setPrintableRepresentation('r');
		setScore(5d);
	}
	
	public static Piece createBlackRook() {
		return new Rook(Piece.Color.BLACK);
	}

	public static Piece createWhiteRook() {
		return new Rook(Piece.Color.WHITE);
	}

}
