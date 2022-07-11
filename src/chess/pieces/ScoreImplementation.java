package chess.pieces;

public class ScoreImplementation implements Score {
	
	@Override
	public double calculateScore(Piece.Type pieceType) {
		double score = 0;
		if (pieceType == Piece.Type.KING) {
			score = getKingScore();
		}
		if (pieceType == Piece.Type.ROOK) {
			score = getRookScore();
		}
		if (pieceType == Piece.Type.PAWN) {
			score = getPawnScore();
		}
		if (pieceType == Piece.Type.BISHOP) {
			score = getBishopScore();
		}
		if (pieceType == Piece.Type.QUEEN) {
			score = getQueenScore();
		}
		return score;
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

}
