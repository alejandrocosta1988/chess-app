package chess.moves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntLocationsTest {

	@Test
	void testCreate() {
		IntLocations locations = new IntLocations("d4", "d6");
	}

}
