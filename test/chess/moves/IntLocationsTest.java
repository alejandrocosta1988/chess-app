package chess.moves;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntLocationsTest {

	private String origin = "d4";
	private String destination = "d6";
	private IntLocations locations;
	
	@BeforeEach
	void createIntLocations() {
		locations = new IntLocations(origin, destination);
	}
	
	@Test
	void testIntLocationsStoresRankIntCorrectedForBoardRankIndex() {
		assertEquals(3, locations.getOriginRank());
		assertEquals(5, locations.getDestinationRank());
	}
	
	@Test
	void testIntLocationsStoresFileIntCorrectedForBoardFileIndex() {
		assertEquals(3, locations.getOriginFile());
		assertEquals(3, locations.getDestinationFile());
	}

}
