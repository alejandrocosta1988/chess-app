package chess.game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import chess.board.Board;
import chess.moves.IntLocations;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class GameTest {

	private Board kingBoard;
	private Piece blackKing;
	private Board queenBoard;
	private Piece whiteQueen;
	private Game kingGame;
	private Game queenGame;
	
	@BeforeEach
	public void setUpKingGame() {
		kingBoard = new Board();
		blackKing = King.createBlackKing();
		kingBoard.placePieceAt("d4", blackKing);
		kingGame = new Game(kingBoard);
	}
	
	@BeforeEach
	public void setUptQueenGame() {
		queenBoard = new Board();
		whiteQueen = Queen.createWhiteQueen();
		queenBoard.placePieceAt("d4", whiteQueen);
		queenGame = new Game(queenBoard);
	}
	
	@Test
	public void testCreateGame() {
		assertNotNull(kingGame.getBoard(), "The board in game cannot be null");
	}
	
	@Test
	public void testPiecesCanBeAddedToTheGameAtGivenLocations() {
		kingGame.putPieceAt(Rook.createBlackRook(), "d3");
		assertTrue(kingGame.getPieceAt("d3").getClass() == Rook.class);
	}
	
	@Test
	public void testAKingCanMoveARankForwards() {
		kingGame.movePieceFromTo("d4", "d5");
		assertTrue(kingGame.checkPosition(blackKing, "d5"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveARankBackwards() {
		kingGame.movePieceFromTo("d4", "d3");
		assertTrue(kingGame.checkPosition(blackKing, "d3"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveAFileTowardsLeft() {
		kingGame.movePieceFromTo("d4", "c4");
		assertTrue(kingGame.checkPosition(blackKing, "c4"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveAFileTowardsRight() {
		kingGame.movePieceFromTo("d4", "e4");
		assertTrue(kingGame.checkPosition(blackKing, "e4"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveARankAndAFileForwards() {
		kingGame.movePieceFromTo("d4", "e5");
		assertTrue(kingGame.checkPosition(blackKing, "e5"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveARankAndAFileBackwards() {
		kingGame.movePieceFromTo("d4", "c3");
		assertTrue(kingGame.checkPosition(blackKing, "c3"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveARankForwardsAndAFileTowardsLeft() {
		kingGame.movePieceFromTo("d4", "c5");
		assertTrue(kingGame.checkPosition(blackKing, "c5"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCanMoveARankBackwardsAndAFileTowardsRight() {
		kingGame.movePieceFromTo("d4", "e3");
		assertTrue(kingGame.checkPosition(blackKing, "e3"));
		assertTrue(kingGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	public void testAKingCannotMoveMoreThanARankPerMove() {
		kingGame.movePieceFromTo("d4", "d6");
		assertTrue(kingGame.checkPosition(blackKing, "d4"));
		assertTrue(kingGame.getPieceAt("d6").isBlank());
	}
	
	@Test
	public void testAKingCannotMoveMoreThanAFilePerMove() {
		kingGame.movePieceFromTo("d4", "f4");
		assertTrue(kingGame.checkPosition(blackKing, "d4"));
		assertTrue(kingGame.getPieceAt("f4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveForwardsInStraightLine() {
		queenGame.movePieceFromTo("d4", "d7");
		assertTrue(queenGame.checkPosition(whiteQueen, "d7"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveBackwardsInStraightLine() {
		queenGame.movePieceFromTo("d4", "d1");
		assertTrue(queenGame.checkPosition(whiteQueen, "d1"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveTowardsRightInStraightLine() {
		queenGame.movePieceFromTo("d4", "g4");
		assertTrue(queenGame.checkPosition(whiteQueen, "g4"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveTowardsLeftInStraightLine() {
		queenGame.movePieceFromTo("d4", "a4");
		assertTrue(queenGame.checkPosition(whiteQueen, "a4"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveForwardsAndToTheRightInStraightLine() {
		queenGame.movePieceFromTo("d4", "h8");
		assertTrue(queenGame.checkPosition(whiteQueen, "h8"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveForwardsAndToTheLeftInStraightLine() {
		queenGame.movePieceFromTo("d4", "a7");
		assertTrue(queenGame.checkPosition(whiteQueen, "a7"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveBackwardsAndToTheLeftInStraightLine() {
		queenGame.movePieceFromTo("d4", "a1");
		assertTrue(queenGame.checkPosition(whiteQueen, "a1"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCanMoveBackwardsAndToTheRightInStraightLine() {
		queenGame.movePieceFromTo("d4", "g1");
		assertTrue(queenGame.checkPosition(whiteQueen, "g1"));
		assertTrue(queenGame.getPieceAt("d4").isBlank());
	}
	
	@Test
	void testAQueenCannotMoveBackwardsAndToTheRightNotInStraightLine() {
		queenGame.movePieceFromTo("d4", "h2");
		assertTrue(queenGame.checkPosition(whiteQueen, "d4"));
		assertTrue(queenGame.getPieceAt("h2").isBlank());
	}
	
	@Test
	void testAQueenCannotMoveBackwardsAndToTheLeftNotInStraightLine() {
		queenGame.movePieceFromTo("d4", "a3");
		assertTrue(queenGame.checkPosition(whiteQueen, "d4"));
		assertTrue(queenGame.getPieceAt("a3").isBlank());
	}
	
	@Test
	void testAQueenCannotMoveForwardsAndToTheLeftNotInStraightLine() {
		queenGame.movePieceFromTo("d4", "a6");
		assertTrue(queenGame.checkPosition(whiteQueen, "d4"));
		assertTrue(queenGame.getPieceAt("a6").isBlank());
	}
	
	@Test
	void testAQueenCannotMoveForwardsAndToTheRightNotInStraightLine() {
		queenGame.movePieceFromTo("d4", "g6");
		assertTrue(queenGame.checkPosition(whiteQueen, "d4"));
		assertTrue(queenGame.getPieceAt("g6").isBlank());
	}
	
}
