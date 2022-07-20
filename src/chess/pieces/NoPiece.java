package chess.pieces;

public class NoPiece extends Piece {

	private NoPiece() {
		super();
	}
	
	public static Piece noPiece() {
		return new NoPiece();
	}
	
}
