package chess.moves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {

	@Test
	void testCreateLocationFromString() {
		Location location = new Location("d3");
		assertEquals(3, location.getFile());
		assertEquals(2, location.getRank());
	}
	
	@Test
	void testMovesALocationToRightByOneSquare() {
		Location location = new Location("d3");
		assertEquals("e3", location.predictMoveToRight());
	}

}
