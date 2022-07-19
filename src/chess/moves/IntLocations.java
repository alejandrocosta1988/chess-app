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
	}

	public int getOriginRank() {
		return originRank;
	}

	public int getDestinationRank() {
		return destinationRank;
	}
	
}
