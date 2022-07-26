package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chess.board.Board;
import chess.moves.IntLocations;

class KingTest extends PieceTest {

	private Piece whiteKing;
	private Piece blackKing;
	
	@BeforeEach
	public void createsWhiteAndBlackKings() {
		whiteKing = createWhitePiece();
		blackKing = createBlackPiece();
	}
	
	@Override
	Piece createBlackPiece() {
		return King.createBlackKing();
	}

	@Override
	Piece createWhitePiece() {
		return King.createWhiteKing();
	}

	@Override
	Piece noPiece() {
		return NoPiece.noPiece();
	}
	
	@Test
	void testABlackKingShouldBeRepresentedWithAnUpperCaseKBetweenSpaces() {
		assertEquals(" K ", blackKing.getRepresentation());
	}
	
	@Test
	void testAWhiteKingShouldBeRepresentedWithALowerCaseKBetweenSpaces() {
		assertEquals(" k ", whiteKing.getRepresentation());
	}
	
	@Test
	void testAKingScoresZero() {
		assertEquals(0d, whiteKing.getScore());
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneRankForwardsThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "d5");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneRankBackwardsThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "d1");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsRightThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "f3");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveMoreThanOneFileTowardsLeftThenCheckMoveReturnsFalse() {
		IntLocations locations = new IntLocations("d3", "b3");
		assertFalse(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneFileFromOriginThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "c3");
		assertTrue(whiteKing.checkMove(locations));
	}
	
	@Test
	void testWhenAKingTriesToMoveOneRankFromOriginThenCheckMoveReturnsTrue() {
		IntLocations locations = new IntLocations("d3", "d4");
		assertTrue(whiteKing.checkMove(locations));
	}
	
	@Test
	void testGivenAKingGetPossibleMovesReturnsAllSquaresThatCouldBeOccupiedByTheKing() {
		Board board = new Board();
		board.placePieceAt("d3", blackKing);
		List<String> expected = new ArrayList<>(Arrays.asList("c3", "c2", "c4", "e3", "d4", "d2"));
		List<String> actual = blackKing.getPossibleMoves("d3", board);
		assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}

}
