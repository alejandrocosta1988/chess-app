package chess.board;

import org.junit.Test;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

public class BoardTest extends TestCase {

	final String EMPTY_RANK = " . ".repeat(8);
	final String RANK_1 = " r  n  b  q  k  b  n  r ";
	final String RANK_2 = " p ".repeat(8);
	final String RANK_7 = RANK_2.toUpperCase();
	final String RANK_8 = RANK_1.toUpperCase();
	
	private Board board;
	
	public void setUp() {
		board = new Board();
		board.setUp();
	}
	
	@Test
	public void testCreate() {
		assertEquals(32, board.countPieces());
		assertEquals(RANK_2, board.printRank(board.rank2));
		assertEquals(RANK_7, board.printRank(board.rank7));
		assertEquals(
				RANK_8 + StringUtil.addNewLine() +
				RANK_7 + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				RANK_2 + StringUtil.addNewLine() +
				RANK_1, 
				board.printBoard());
	}
	
	@Test
	public void testABoardIsEmptyWhenCreated() {
		Board emptyBoard = new Board();
		assertEquals(0, emptyBoard.countPieces());
		assertEquals(
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK + StringUtil.addNewLine() +
				EMPTY_RANK,
				emptyBoard.printBoard());
	}
	
	@Test
	public void testABoardCreates16BlackAnd16WhitePieces() {
		assertEquals(16, board.countBlackPieces());
		assertEquals(16, board.countWhitePieces());
	}
	
	@Test
	public void testCountsSpecificTypesOfPiecesTakingIntoAccountItsColor() {
		assertEquals(8, board.countPieces(Piece.Type.PAWN, Piece.Color.BLACK));
		assertEquals(2, board.countPieces(Piece.Type.BISHOP, Piece.Color.WHITE));
	}
	
	@Test
	public void testRetrieveAPieceByAGivenLocation() {
		Piece blackRook = Piece.createBlackRook();
		Piece whiteKing = Piece.createWhiteKing();
		assertEquals(blackRook.getRepresentation(), board.getPiece("a8").getRepresentation());
		assertEquals(whiteKing.getRepresentation(), board.getPiece("e1").getRepresentation());
	}
	
}
