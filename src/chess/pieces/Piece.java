package chess.pieces;

import chess.moves.IntLocations;

public abstract class Piece implements Comparable<Piece> {
	
	public enum Color { WHITE, BLACK };
	private Color color;
	private char printableRepresentation;
	private double score;
	
	protected Piece(Color color) {
		this.color = color;
	}
	
	public String getRepresentation() {
		if (isBlack()) {
			return representBlackPiece();
		}
		return representWhitePiece();
	}
	
	private String representBlackPiece() {
		return " " + Character.toUpperCase(printableRepresentation) + " ";
	}
	
	private String representWhitePiece() {
		return " " + printableRepresentation + " ";
	}
	
	public boolean isBlack() {
		return color == Color.BLACK;
	}
	
	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public boolean isBlank() {
		return getClass() == NoPiece.class;
	}

	public boolean isNotBlank() {
		return getClass() != NoPiece.class;
	}

	public Color getColor() {
		return color;
	}

	public double getScore() {
		return score;
	}
	
	public boolean isPawn() {
		return getClass() == Pawn.class;
	}
	
	public boolean isColor(Color color) {
		return this.color == color;
	}
	
	public boolean checkMove(IntLocations locations) {
		return false;
	}

	@Override
	public int compareTo(Piece that) {
		return Double.compare(that.getScore(), this.getScore());
	}

}
