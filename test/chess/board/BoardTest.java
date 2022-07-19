package chess.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.pieces.King;
import chess.pieces.Piece;
import util.StringUtil;

public class BoardTest {

	final String EMPTY_RANK = " . ".repeat(8);
	final String RANK_1 = " r  n  b  q  k  b  n  r ";
	final String RANK_2 = " p ".repeat(8);
	final String RANK_7 = RANK_2.toUpperCase();
	final String RANK_8 = RANK_1.toUpperCase();
	
	private Piece blackKing;
	private Board board;
	private Board kingBoard;
	
	@BeforeEach
	public void createAndSetsUpBoard() {
		board = new Board();
		board.setUp();
	}
	
	@BeforeEach
	public void createABoardWithAKing() {
		blackKing = King.createBlackKing();
		kingBoard = new Board();
		kingBoard.placePieceAt("d4", blackKing);
		
	}
	
	@Test
	public void testCreate() {
		assertEquals(32, board.countPieces());
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
	public void testPiecesCanBePlacedAtGivenLocationsOnABoard() {
		Board emptyBoard = new Board();
		Piece blackKing = King.createBlackKing();
		Piece blackRook = Piece.createBlackRook();
		Piece whiteKing = King.createWhiteKing();
		emptyBoard.placePieceAt("b6", blackKing);
		emptyBoard.placePieceAt("b5", blackRook);
		emptyBoard.placePieceAt("c4", whiteKing);
		assertEquals(blackKing, emptyBoard.getPiece("b6"));
		assertEquals(blackRook, emptyBoard.getPiece("b5"));
		assertEquals(whiteKing, emptyBoard.getPiece("c4"));
	}
	
	@Test
	public void testABoardIsSetUpWith16BlackAnd16WhitePieces() {
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
		Piece whiteKing = King.createWhiteKing();
		assertEquals(blackRook.getRepresentation(), board.getPiece("a8").getRepresentation());
		assertEquals(whiteKing.getRepresentation(), board.getPiece("e1").getRepresentation());
	}
	
	@Test
	public void testEvaluateTheStrengthOfWhiteAndBlackPieces() {
		Board strengthBoard = new Board();
		strengthBoard.placePieceAt("b8", King.createBlackKing());
		strengthBoard.placePieceAt("c8", Piece.createBlackRook());
		strengthBoard.placePieceAt("a7", Piece.createBlackPawn());
		strengthBoard.placePieceAt("c7", Piece.createBlackPawn());
		strengthBoard.placePieceAt("d7", Piece.createBlackBishop());
		strengthBoard.placePieceAt("b6", Piece.createBlackPawn());
		strengthBoard.placePieceAt("e6", Piece.createBlackQueen());
		assertEquals(20d, strengthBoard.evaluateStrength(Piece.Color.BLACK));
		
		strengthBoard.placePieceAt("e1", Piece.createWhiteRook());
		strengthBoard.placePieceAt("f1", King.createWhiteKing());
		strengthBoard.placePieceAt("f2", Piece.createWhitePawn());
		strengthBoard.placePieceAt("g2", Piece.createWhitePawn());
		strengthBoard.placePieceAt("h3", Piece.createWhitePawn());
		strengthBoard.placePieceAt("f4", Piece.createWhiteKnight());
		strengthBoard.placePieceAt("g4", Piece.createWhiteQueen());
		assertEquals(19.5, strengthBoard.evaluateStrength(Piece.Color.WHITE));
	}
	
	@Test
	public void testPawnsGetHalfScoreIfThereAreMoreThanOneInTheSameFile() {
		Board strengthBoard = new Board();
		strengthBoard.placePieceAt("c8", King.createBlackKing());
		strengthBoard.placePieceAt("d8", Piece.createBlackRook());
		strengthBoard.placePieceAt("f2", Piece.createWhitePawn());
		strengthBoard.placePieceAt("f4", Piece.createWhitePawn());
		strengthBoard.placePieceAt("d4", Piece.createWhitePawn());
		strengthBoard.placePieceAt("e2", King.createWhiteKing());
		assertEquals(2d, strengthBoard.evaluateStrength(Piece.Color.WHITE));
	}
	
	@Test
	public void testAssignEachPieceAStrength() {
		board.assignStrengthToPieces();
		assertEquals(5.0, board.getPiece("a8").getStrength());
		assertEquals(9.0, board.getPiece("d1").getStrength());
		assertEquals(1.0, board.getPiece("d2").getStrength());
	}
	
	@Test
	public void testWhiteOrBlackPiecesAreGatheredInACollectionSortedAccordingToTheirStrength() {
		board.collectWhitePieces();
		assertEquals(Piece.Type.QUEEN, board.getWhitePieces().get(0).getType());
		assertEquals(Piece.Type.ROOK, board.getWhitePieces().get(1).getType());
		board.collectBlackPieces();
		assertEquals(Piece.Type.QUEEN, board.getBlackPieces().get(0).getType());
		assertEquals(Piece.Type.ROOK, board.getBlackPieces().get(1).getType());
	}
	
	@Test
	public void testChecksPiecePosition() {
		Piece piece = board.getPiece("c3");
		assertTrue(board.checkPosition(piece, "c3"));
		assertFalse(board.checkPosition(piece, "d3"));
	}
	
}
