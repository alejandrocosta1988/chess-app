package chess.util;

public class LocationUtil {

	private LocationUtil() {
		super();
	}
	
	public static int convertRankToInt(String location) {
		int correctionToConvertToIndex = 1;
		return Character.getNumericValue(location.charAt(1)) - correctionToConvertToIndex;
	}

}
