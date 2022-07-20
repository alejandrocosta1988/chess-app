package chess.pieces;

public class NoPiece extends Piece {

	private NoPiece() {
		super();
		setScore(0d);
		setPrintableRepresentation('.');
	}
	
	public static Piece noPiece() {
		return new NoPiece();
	}
	
	@Override
	public String getRepresentation() {
		return " " + printableRepresentation + " ";
	}
	
}
