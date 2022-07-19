package chess;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages(value = { "chess.pieces", "chess.board", "chess.game" })
public class AllUnitTests {

	
}
