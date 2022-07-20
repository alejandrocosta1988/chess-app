package chess.pieces;

public class Queen extends Piece {
	
	private Queen(Piece.Color color) {
		super(color);
		setScore(9.0);
		setPrintableRepresentation('q');
	}
	
	public static Piece createBlackQueen() {
		return new Queen(Piece.Color.BLACK);
	}
	
	public static Piece createWhiteQueen() {
		return new Queen(Piece.Color.WHITE);
	}
	
}
