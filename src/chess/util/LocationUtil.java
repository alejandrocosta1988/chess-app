package chess.util;

import java.util.HashMap;
import java.util.Map;

public class LocationUtil {
	
	private static Map<Character, Integer> fileOptions = new HashMap<>();

	private LocationUtil() {
		super();
	}
	
	public static int convertRankToInt(String location) {
		int correctionToConvertToIndex = 1;
		return Character.getNumericValue(location.charAt(1)) - correctionToConvertToIndex;
	}
	
	public static int convertFileToInt(String location) {
		if (fileOptions.isEmpty()) {
			createFileOptions();
		}
		Character fileCharacter = location.charAt(0);
		return fileOptions.get(fileCharacter);
	}

	private static void createFileOptions() {
		fileOptions.put('a', 0);
		fileOptions.put('b', 1);
		fileOptions.put('c', 2);
		fileOptions.put('d', 3);
		fileOptions.put('e', 4);
		fileOptions.put('f', 5);
		fileOptions.put('g', 6);
		fileOptions.put('h', 7);
	}
}
