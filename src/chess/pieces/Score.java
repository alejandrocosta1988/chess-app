package chess.pieces;

public interface Score {
	double calculateScore(Piece.Type pieceType);
	double calculateHalfPawnScore();
}
