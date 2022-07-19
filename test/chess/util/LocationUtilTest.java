package chess.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationUtilTest {

	@Test
	void testGivenALocationStringThenConvertRankReturnsARankInt() {
		assertEquals(3, LocationUtil.convertRankToInt("d4"));
	}

}
