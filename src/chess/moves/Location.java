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
		int predictedFile = addPredictedSquare(file);
		int predictedRank = rank;
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	public String predictMoveToLeft() {
		int predictedFile = subtractPredictedSquare(file);
		int predictedRank = rank;
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	public String predictUpwardsMove() {
		int predictedFile = file;
		int predictedRank = addPredictedSquare(rank);
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	public String predictBackwardsMove() {
		int predictedFile = file;
		int predictedRank = subtractPredictedSquare(rank);
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	public String predictBackwardsMoveToTheLeft() {
		int predictedFile = subtractPredictedSquare(file);
		int predictedRank = subtractPredictedSquare(rank);
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	public String predictUpwardsMoveToTheLeft() {
		int predictedFile = subtractPredictedSquare(file);
		int predictedRank = addPredictedSquare(rank);
		return translateSquareToString(predictedFile, predictedRank);
	}
	
	private int addPredictedSquare(int square) {
		return square + 1;
	}
	
	private int subtractPredictedSquare(int square) {
		return square - 1;
	}
	
	private String translateSquareToString(int file, int rank) {
		StringBuilder square = new StringBuilder();
		square.append(LocationUtil.convertIntToFile(file));
		square.append(LocationUtil.convertIntToRank(rank));
		return square.toString();
	}
}
