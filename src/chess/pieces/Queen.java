package chess.pieces;

import chess.moves.IntLocations;

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
	
	public boolean checkMove(IntLocations locations) {
		if (isSameFile(locations) || isSameRank(locations)) {
			return true;
		}
		if (isSameDifference(locations)) {
			return true;
		}
		return false;
	}
	
	private boolean isSameFile(IntLocations locations) {
		if (locations.getDestinationFile() == locations.getOriginFile()) {
			return true;
		}
		return false;
	}
	
	private boolean isSameRank(IntLocations locations) {
		if (locations.getDestinationRank() == locations.getOriginRank()) {
			return true;
		}
		return false;
	}
	
	private boolean isSameDifference(IntLocations locations) {
		return getDifferenceInFile(locations) == getDifferenceInRank(locations);
	}
	
	private int getDifferenceInFile(IntLocations locations) {
		if (isMoveTowardsRight(locations)) {
			return locations.getDestinationFile() - locations.getOriginFile();
		}
		return locations.getOriginFile() - locations.getDestinationFile();
	}
	
	private boolean isMoveTowardsRight(IntLocations locations) {
		return locations.getDestinationFile() > locations.getOriginFile();
	}
	
	private int getDifferenceInRank(IntLocations locations) {
		if (isMoveForwards(locations)) {
			return locations.getDestinationRank() - locations.getOriginRank();
		}
		return locations.getOriginRank() - locations.getDestinationRank();
	}
	
	private boolean isMoveForwards(IntLocations locations) {
		return locations.getDestinationRank() > locations.getOriginRank();
	}
	
}
