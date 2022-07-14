package chess.pieces;

import java.util.EnumMap;
import java.util.Map;

public class ScoreImplementation implements Score {
	
	private final double KING_SCORE = 0d;
	private final double QUEEN_SCORE = 9d;
	private final double ROOK_SCORE = 5d;
	private final double BISHOP_SCORE = 3d;
	private final double KNIGHT_SCORE = 2.5;
	private final double PAWN_SCORE = 1d;
	
	private Map<Piece.Type, Double> scores = null;
	
	@Override
	public double calculateScore(Piece.Type pieceType) {
		return getScores().get(pieceType);
	}
	
	private Map<Piece.Type, Double> getScores() {
		if (scores == null) {
			loadScores();
		}
		return scores;
	}
	
	private void loadScores() {
		scores = new EnumMap<Piece.Type, Double>(Piece.Type.class);
		scores.put(Piece.Type.KING, KING_SCORE);
		scores.put(Piece.Type.QUEEN, QUEEN_SCORE);
		scores.put(Piece.Type.BISHOP, BISHOP_SCORE);
		scores.put(Piece.Type.ROOK, ROOK_SCORE);
		scores.put(Piece.Type.KNIGHT, KNIGHT_SCORE);
		scores.put(Piece.Type.PAWN, PAWN_SCORE);
	}
	
	@Override
	public double calculateHalfPawnScore() {
		return PAWN_SCORE / 2;
	}

}
