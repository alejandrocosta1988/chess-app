package chess.moves;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest {

	private Location location;
	
	@BeforeEach
	void createLocation() {
		location = new Location("d3");
	}
	
	@Test
	void testCreateLocationFromString() {
		assertEquals(3, location.getFile());
		assertEquals(2, location.getRank());
	}
	
	@Test
	void testPredictsTheStringLocationAfterMoveToRightByOneSquare() {
		assertEquals("e3", location.predictMoveToRight());
	}
	
	@Test
	void testPredictsTheStringLocationAfterMoveToLeftByOneSquare() {
		assertEquals("c3", location.predictMoveToLeft());
	}
	
	@Test
	void testPredictsTheStringLocationAfterUpwardsMoveOfOneSquare() {
		assertEquals("d4", location.predictUpwardsMove());
	}
	
	@Test
	void testPredictsTheStringLocationAfterBackwardsMoveOfOneSquare() {
		assertEquals("d2", location.predictBackwardsMove());
	}
	
	@Test
	void testPredictsTheStringLocationAfterBackwardsMoveToTheLeft() {
		assertEquals("c2", location.predictBackwardsMoveToTheLeft());
	}
	
	@Test
	void testPredictsTheStringLocationAfterUpwardsMoveToTheLeft() {
		assertEquals("c4", location.predictUpwardsMoveToTheLeft());
	}

}
