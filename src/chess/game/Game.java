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
		if (finalRank > initialRank + 1 || finalRank < initialRank - 1) {
			return;
		}
		if (finalFile > initialFile + 1 || finalFile < initialFile - 1) {
			return;
		}
		board.placePieceAt(destinyLocation, pieceInMovement);
		board.placePieceAt(currentLocation, Piece.noPiece());
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

	public Piece getPieceAt(String location) {
		return board.getPiece(location);
	}

}
