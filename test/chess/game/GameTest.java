package chess.game;

import org.junit.Test;

import chess.board.Board;
import chess.pieces.Piece;
import junit.framework.TestCase;

public class GameTest extends TestCase {

	private Board kingBoard;
	private Game game;
	
	@Override
	public void setUp() {
		kingBoard = new Board();
		kingBoard.placePieceAt("d4", Piece.createBlackKing());
		game = new Game(kingBoard);
	}
	
	@Test
	public void testCreateGame() {
		assertNotNull("The board in game cannot be null", game.getBoard());
	}
	
	@Test
	public void testPiecesCanBeAddedToTheGameAtGivenLocations() {
		game.putPieceAt(Piece.createBlackRook(), "d3");
		assertTrue(game.getPieceAt("d3").getType() == Piece.Type.ROOK);
	}
	
	@Test
	public void testKingsAreAllowedToMoveASquareForwards() {
		game.movePiece("d4", "d5");
		assertTrue(game.getPieceAt("d5").getType() == Piece.Type.KING);
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreAllowedToMoveASquareBackwards() {
		game.movePiece("d4", "d3");
		assertTrue(game.getPieceAt("d3").getType() == Piece.Type.KING);
		assertTrue(game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreAllowedToMoveAFileToTheLeft() {
		game.movePiece("d4", "c4");
		assertTrue("Should be Piece.Type.KING", game.getPieceAt("c4").getType() == Piece.Type.KING);
		assertTrue("Should be Piece.Type.No_Piece", game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreAllowedToMoveAFileToTheRight() {
		game.movePiece("d4", "e4");
		assertTrue("Should be Piece.Type.KING", game.getPieceAt("e4").getType() == Piece.Type.KING);
		assertTrue("Should be Piece.Type.No_Piece", game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreAllowedToMoveAFileAndARankAtSameTime() {
		game.movePiece("d4", "e5");
		assertTrue("Should be Piece.Type.KING", game.getPieceAt("e5").getType() == Piece.Type.KING);
		assertTrue("Should be Piece.Type.No_Piece", game.getPieceAt("d4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreNotAllowedToMoveMoreThanARankPerTime() {
		game.movePiece("d4", "d6");
		assertTrue("Should be Piece.Type.KING", game.getPieceAt("d4").getType() == Piece.Type.KING);
		assertTrue("Should be Piece.Type.No_Piece", game.getPieceAt("d6").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testKingsAreNotAllowedToMoveMoreThanAFilePerTime() {
		game.movePiece("d4", "f4");
		assertTrue("Should be Piece.Type.KING", game.getPieceAt("d4").getType() == Piece.Type.KING);
		assertTrue("Should be Piece.Type.No_Piece", game.getPieceAt("f4").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testQueensCanMoveAnyNumberOfSquaresForwardsInStraightLine() {
		game.putPieceAt(Piece.createBlackQueen(), "b3");
		game.movePiece("b3", "b8");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("b8").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("b3").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testQueensCanMoveAnyNumberOfSquaresBackwardsInStraightLine() {
		game.putPieceAt(Piece.createBlackQueen(), "e7");
		game.movePiece("e7", "e1");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("e1").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("e7").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testQueensAreNotAllowedToBreakStraigthLinesWhenMovingForwards() {
		game.putPieceAt(Piece.createWhiteQueen(), "f1");
		game.movePiece("f1", "g7");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("f1").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("g7").getType() == Piece.Type.NO_PIECE);
		game.movePiece("f1", "e7");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("f1").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("e7").getType() == Piece.Type.NO_PIECE);
	}
	
	@Test
	public void testQueensCanMoveAnyNumberOfSquaresInDiagonalWhenMovingForwards() {
		game.putPieceAt(Piece.createWhiteQueen(), "f1");
		game.movePiece("f1", "d3");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("d3").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("f1").getType() == Piece.Type.NO_PIECE);
		game.movePiece("d3", "h7");
		assertTrue("Should be Piece.Type.QUEEN", game.getPieceAt("h7").getType() == Piece.Type.QUEEN);
		assertTrue("Should be Piece.Type.NO_PIECE", game.getPieceAt("d3").getType() == Piece.Type.NO_PIECE);
	}
	
}
