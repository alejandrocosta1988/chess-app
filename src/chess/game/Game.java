package chess.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chess.board.Board;
import chess.pieces.Piece;

public class Game {

	private Board board;
	
	public Game(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}

	public void movePiece(String currentLocation, String destinyLocation) {
		Piece pieceInMovement = getPieceAt(currentLocation);
		int initialRank = getRankIntFromStringLocation(currentLocation);
		int finalRank = getRankIntFromStringLocation(destinyLocation);
		int initialFile = getFileIntFromStringLocation(currentLocation); 
		int finalFile = getFileIntFromStringLocation(destinyLocation);
		
		if (pieceInMovement.getType() == Piece.Type.KING) {
			if (finalRank > initialRank + 1 || finalRank < initialRank - 1) {
				return;
			}
			if (finalFile > initialFile + 1 || finalFile < initialFile - 1) {
				return;
			}
		}
		if (pieceInMovement.getType() == Piece.Type.QUEEN) {
			if (finalRank > initialRank ) {
				if (finalFile > initialFile) {
					int difference = finalFile - initialFile;
					for (int i = 0; i < difference; i++) {
						finalFile--;
						finalRank--;
					}
					if (finalFile != initialFile || finalRank != initialRank) return;
				}
				if (finalFile < initialFile) {
					int difference = initialFile - finalFile;
					for (int i = 0; i < difference; i++) {
						finalFile++;
						finalRank--;
					}
					if (finalFile != initialFile || finalRank != initialRank) return;
				}
			}
		}
		board.placePieceAt(destinyLocation, pieceInMovement);
		board.placePieceAt(currentLocation, Piece.noPiece());
	}
	
	public Piece getPieceAt(String location) {
		return board.getPiece(location);
	}
	
	private int getRankIntFromStringLocation(String location) {
		int correctionToConvertToIndex = 1;
		return Character.getNumericValue(location.charAt(1)) - correctionToConvertToIndex;
	}
	
	private int getFileIntFromStringLocation(String location) {
		int fileInt = 0;
		Character fileCharacter = location.charAt(0);
		List<Character> fileOptions = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
		for (Character fileOption : fileOptions) {
			if (fileCharacter.equals(fileOption))
				fileInt = fileOptions.indexOf(fileOption);
		}
		return fileInt;
	}

	public void putPieceAt(Piece piece, String location) {
		board.placePieceAt(location, piece);
	}

}
