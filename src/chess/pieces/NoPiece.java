package chess.pieces;

public class NoPiece extends Piece {

	private char printableRepresentation = '.';
	private double score = 0d;
	
	private NoPiece() {
		super();
	}
	
	public static Piece noPiece() {
		return new NoPiece();
	}
	
	@Override
	public String getRepresentation() {
		return " " + printableRepresentation + " ";
	}
	
}
