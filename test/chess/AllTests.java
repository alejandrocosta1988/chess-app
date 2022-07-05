package chess;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ chess.pieces.PieceTest.class, chess.board.BoardTest.class })
public class AllTests {

}
