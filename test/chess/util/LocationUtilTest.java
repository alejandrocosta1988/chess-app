package chess.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationUtilTest {

	@Test
	void testGivenALocationStringThenConvertRankReturnsARankIntCorrectedToBoardIndexes() {
		assertEquals(3, LocationUtil.convertRankToInt("d4"));
	}
	
	@Test
	void testGivenALocationStringThenConvertFileReturnsAFileIntCorrectedToBoardIndexes() {
		assertEquals(3, LocationUtil.convertFileToInt("d4"));
	}
	
	@Test
	void testGivenAnIntThenConvertIntToRankReturnsAStringRank() {
		assertEquals("3", LocationUtil.convertIntToRank(2));
	}
	
	@Test
	void testGivenAnIntThenConvertIntToFileReturnsACharFile() {
		assertEquals('d', LocationUtil.convertIntToFile(3));
	}
	
}
