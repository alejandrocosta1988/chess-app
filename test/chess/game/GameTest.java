package chess.game;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import chess.board.Board;
import chess.pieces.King;
import chess.pieces.Piece;

public class GameTest {

	private Board kingBoard;
	private Piece blackKing;
	private Game game;
	
	@BeforeEach
	public void setUp() {
		kingBoard = new Board();
		blackKing = King.createBlackKing();
		kingBoard.placePieceAt("d4", blackKing);
		game = new Game(kingBoard);
	}
	
	@Test
	public void testCreateGame() {
		assertNotNull(game.getBoard(), "The board in game cannot be null");
	}
	
	@Test
	public void testPiecesCanBeAddedToTheGameAtGivenLocations() {
		game.putPieceAt(Piece.createBlackRook(), "d3");
		assertTrue(game.getPieceAt("d3").getType() == Piece.Type.ROOK);
	}
	
	@Test
	public void testAKingCanMoveARankForwards() {
		game.movePieceFromTo("d4", "d5");
		assertTrue(game.checkPosition(blackKing, "d5"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveARankBackwards() {
		game.movePieceFromTo("d4", "d3");
		assertTrue(game.checkPosition(blackKing, "d3"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveAFileTowardsLeft() {
		game.movePieceFromTo("d4", "c4");
		assertTrue(game.checkPosition(blackKing, "c4"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveAFileTowardsRight() {
		game.movePieceFromTo("d4", "e4");
		assertTrue(game.checkPosition(blackKing, "e4"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveARankAndAFileForwards() {
		game.movePieceFromTo("d4", "e5");
		assertTrue(game.checkPosition(blackKing, "e5"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveARankAndAFileBackwards() {
		game.movePieceFromTo("d4", "c3");
		assertTrue(game.checkPosition(blackKing, "c3"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveARankForwardsAndAFileTowardsLeft() {
		game.movePieceFromTo("d4", "c5");
		assertTrue(game.checkPosition(blackKing, "c5"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testAKingCanMoveARankBackwardsAndAFileTowardsRight() {
		game.movePieceFromTo("d4", "e3");
		assertTrue(game.checkPosition(blackKing, "e3"));
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Disabled
	@Test
	public void testAKingCannotMoveMoreThanARankPerMove() {
		game.movePieceFromTo("d4", "d6");
		assertTrue(game.checkPosition(blackKing, "d4"));
		assertTrue(game.getPieceAt("d6").getType() == Piece.Type.NO_PIECE);
	}
	
	@Disabled
	@Test
	public void testAKingCannotMoveMoreThanAFilePerMove() {
		game.movePieceFromTo("d4", "f4");
		assertTrue(game.checkPosition(blackKing, "d4"));
		assertTrue(game.getPieceAt("f4").getType() == Piece.Type.NO_PIECE);
	}
	
}
