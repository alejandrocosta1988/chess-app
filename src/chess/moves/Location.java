package chess.moves;

import chess.util.LocationUtil;

public class Location {

	int rank;
	int file;
	
	public Location(String location) {
		rank = LocationUtil.convertRankToInt(location);
		file = LocationUtil.convertFileToInt(location);
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getFile() {
		return file;
	}
	
	public String predictMoveToRight() {
		int predictedFile = file + 1;
		int predictedRank = rank;
		StringBuilder prediction = new StringBuilder();
		prediction.append(LocationUtil.convertIntToFile(predictedFile));
		prediction.append(LocationUtil.convertIntToRank(predictedRank));
		return prediction.toString();
	}
}
