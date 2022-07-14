package chess.pieces;

public class ScoreImplementation implements Score {
	
	@Override
	public double calculateScore(Piece.Type pieceType) {
		switch (pieceType) {
			case KING: return getKingScore();
			case QUEEN: return getQueenScore();
			case BISHOP: return getBishopScore();
			case ROOK: return getRookScore();
			case KNIGHT: return getKnightScore();
			case PAWN: return getPawnScore();
			default: return 0;
		}
	}
	
	private double getKingScore() {
		return 0d;
	}
	
	private double getRookScore() {
		return 5d;
	}
	
	private double getPawnScore() {
		return 1d;
	}
	
	private double getBishopScore() {
		return 3d;
	}
	
	private double getQueenScore() {
		return 9d;
	}
	
	private double getKnightScore() {
		return 2.5;
	}
	
	@Override
	public double calculateHalfPawnScore() {
		return getPawnScore() / 2;
	}

}
