package chess.pieces;

import chess.moves.IntLocations;

public class King extends Piece {

	private King(Piece.Color color) {
		super(color);
		setScore(0.0);
		setPrintableRepresentation('k');
	}
	
	public static Piece createBlackKing() {
		return new King(Piece.Color.BLACK);
	}
	
	public static Piece createWhiteKing() {
		return new King(Piece.Color.WHITE);
	}
	
	public boolean checkMove(IntLocations locations) {
		if (checkFilesInMove(locations) || checkRanksInMove(locations)) {
			return false;
		}
		return true;
	}
	
	private boolean checkFilesInMove(IntLocations locations) {
		return locations.getDestinationFile() > locations.getOriginFile() + 1 || 
				locations.getDestinationFile() < locations.getOriginFile() - 1;
	}
	
	private boolean checkRanksInMove(IntLocations locations) {
		return locations.getDestinationRank() > locations.getOriginRank() + 1 || 
				locations.getDestinationRank() < locations.getOriginRank() - 1;
	}
	
}
