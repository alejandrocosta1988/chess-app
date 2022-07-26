package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.board.Board;
import chess.moves.IntLocations;
import chess.moves.Location;

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
	
	public List<String> getPossibleMoves(String location, Board board){
		List<String> possibleMoves = new ArrayList<>();
		Location currentLocation = new Location(location);
		possibleMoves.add(predictMoveToRight(currentLocation));
		possibleMoves.add(predictMoveToLeft(currentLocation));
		possibleMoves.add(predictUpwardsMove(currentLocation));
		possibleMoves.add(predictBackwardsMove(currentLocation));
		possibleMoves.add(predictBackwardsMoveToTheLeft(currentLocation));
		possibleMoves.add(predictUpwardsMoveToTheLeft(currentLocation));
		return possibleMoves;
	}
	
	private String predictMoveToRight(Location location) {
		return location.predictMoveToRight();
	}
	
	private String predictMoveToLeft(Location location) {
		return location.predictMoveToLeft();
	}
	
	private String predictUpwardsMove(Location location) {
		return location.predictUpwardsMove();
	}
	
	private String predictBackwardsMove(Location location) {
		return location.predictBackwardsMove();
	}
	
	private String predictBackwardsMoveToTheLeft(Location location) {
		return location.predictBackwardsMoveToTheLeft();
	}
	
	private String predictUpwardsMoveToTheLeft(Location location) {
		return location.predictUpwardsMoveToTheLeft();
	}
	
}
