package chess.moves;

import chess.util.LocationUtil;

public class IntLocations {

	private int originRank;
	private int destinationRank;
	private int originFile;
	private int destinationFile;
	
	public IntLocations(String originLocation, String destinationLocation) {
		originRank = LocationUtil.convertRankToInt(originLocation);
		destinationRank = LocationUtil.convertRankToInt(destinationLocation);
		originFile = LocationUtil.convertFileToInt(originLocation);
		destinationFile = LocationUtil.convertFileToInt(destinationLocation);
	}

	public int getOriginRank() {
		return originRank;
	}

	public int getDestinationRank() {
		return destinationRank;
	}

	public int getOriginFile() {
		return originFile;
	}
	
	public int getDestinationFile() {
		return destinationFile;
	}
	
}
