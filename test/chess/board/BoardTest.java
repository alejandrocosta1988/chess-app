package chess.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.StringUtil;

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
		Piece blackRook = Rook.createBlackRook();
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
	public void testRetrieveAPieceByAGivenLocation() {
		Piece blackRook = Rook.createBlackRook();
		Piece whiteKing = King.createWhiteKing();
		assertEquals(blackRook.getRepresentation(), board.getPiece("a8").getRepresentation());
		assertEquals(whiteKing.getRepresentation(), board.getPiece("e1").getRepresentation());
	}
	
	@Test
	public void testEvaluateTheStrengthOfWhiteAndBlackPieces() {
		Board strengthBoard = new Board();
		strengthBoard.placePieceAt("b8", King.createBlackKing());
		strengthBoard.placePieceAt("c8", Rook.createBlackRook());
		strengthBoard.placePieceAt("a7", Pawn.createBlackPawn());
		strengthBoard.placePieceAt("c7", Pawn.createBlackPawn());
		strengthBoard.placePieceAt("d7", Bishop.createBlackBishop());
		strengthBoard.placePieceAt("b6", Pawn.createBlackPawn());
		strengthBoard.placePieceAt("e6", Queen.createBlackQueen());
		assertEquals(20d, strengthBoard.evaluateStrength(Piece.Color.BLACK));
		
		strengthBoard.placePieceAt("e1", Rook.createWhiteRook());
		strengthBoard.placePieceAt("f1", King.createWhiteKing());
		strengthBoard.placePieceAt("f2", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("g2", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("h3", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("f4", Knight.createWhiteKnight());
		strengthBoard.placePieceAt("g4", Queen.createWhiteQueen());
		assertEquals(19.5, strengthBoard.evaluateStrength(Piece.Color.WHITE));
	}
	
	@Test
	public void testPawnsGetHalfScoreIfThereAreMoreThanOneInTheSameFile() {
		Board strengthBoard = new Board();
		strengthBoard.placePieceAt("c8", King.createBlackKing());
		strengthBoard.placePieceAt("d8", Rook.createBlackRook());
		strengthBoard.placePieceAt("f2", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("f4", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("d4", Pawn.createWhitePawn());
		strengthBoard.placePieceAt("e2", King.createWhiteKing());
		assertEquals(2d, strengthBoard.evaluateStrength(Piece.Color.WHITE));
	}
	
	@Test
	public void testAssignEachPieceAStrength() {
		assertEquals(5.0, board.getPiece("a8").getScore());
		assertEquals(9.0, board.getPiece("d1").getScore());
		assertEquals(1.0, board.getPiece("d2").getScore());
	}
	
	@Test
	public void testWhiteOrBlackPiecesAreGatheredInACollectionSortedAccordingToTheirStrength() {
		board.collectWhitePieces();
		assertEquals(Queen.class, board.getWhitePieces().get(0).getClass());
		assertEquals(Rook.class, board.getWhitePieces().get(1).getClass());
		board.collectBlackPieces();
		assertEquals(Queen.class, board.getBlackPieces().get(0).getClass());
		assertEquals(Rook.class, board.getBlackPieces().get(1).getClass());
	}
	
	@Test
	public void testChecksPiecePosition() {
		Piece piece = board.getPiece("c3");
		assertTrue(board.checkPosition(piece, "c3"));
		assertFalse(board.checkPosition(piece, "d3"));
	}
	
}
