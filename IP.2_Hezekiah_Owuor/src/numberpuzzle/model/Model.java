package numberpuzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	Puzzle puzzle;
	boolean gameOver;
	NumberPiece selectedPieceOne;
	int numMoves = 0;
	
	public Model() {
		
	}
	
	
	public boolean tryMove(MoveType dir, Puzzle p) {
		
		if(selectedPieceOne == null) {
			return false;
		}
		
		for(MoveType move : availableMoves() ) {
			if(dir == move) {
				selectedPieceOne.move(dir, p);
				numMoves++;
				return true;
			}
		}
		
		return true;
		
	}

	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		
		if(selectedPieceOne == null) {
			return moves;
		}
		
		return availableMoves(selectedPieceOne);
	}
	
	public List<MoveType> availableMoves(NumberPiece p) {
		
		ArrayList<MoveType> moves = new ArrayList<>();
		
		boolean leftAvailable = true;
		boolean rightAvailable = true;
		boolean upAvailable = true;
		boolean downAvailable = true;

		
		//Check if invalid piece
		if(puzzle.operation(new Coordinate(p.column, p.row)) == 0) {
			leftAvailable = false;
			rightAvailable = false;
			upAvailable = false;
			downAvailable = false;
			
			return moves;
		}
		
		//Left -> Subtract
		
		if((puzzle.operation(new Coordinate(p.column - 1, p.row)) < p.number) || 
				((puzzle.operation(new Coordinate(p.column - 1, p.row)) == 0) || 
					(puzzle.operation(new Coordinate(p.column - 1, p.row)) == -1))) {
			leftAvailable = false;
		}
		
		if(leftAvailable) {
			moves.add(MoveType.Left);
		}
		
		//Right -> Add
		
		if(((puzzle.operation(new Coordinate(p.column + 1, p.row)) < 1) ||
				((puzzle.operation(new Coordinate(p.column +1, p.row)) == 0) || 
					(puzzle.operation(new Coordinate(p.column +1, p.row)) == -1)))) {
			rightAvailable = false;
		}
		
		if(rightAvailable) {
			moves.add(MoveType.Right);
		}
		
		//Up -> multiply
			
		if((puzzle.operation(new Coordinate(p.column, p.row - 1)) < 1) ||
				((puzzle.operation(new Coordinate(p.column, p.row - 1)) == 0) || 
						(puzzle.operation(new Coordinate(p.column, p.row - 1)) == -1))) {
			upAvailable = false;
		}
				
		if(upAvailable) {
			moves.add(MoveType.Up);
		}
		
		//Down -> Divide
				
		if(((puzzle.operation(new Coordinate(p.column, p.row + 1))%p.number) != 0 || (p.number == 0)) || 
				((puzzle.operation(new Coordinate(p.column, p.row + 1)) == 0) || 
						(puzzle.operation(new Coordinate(p.column, p.row + 1)) == -1))) {
			downAvailable = false;
		}
				
		if(downAvailable) {
			moves.add(MoveType.Down);
		}	
		
		return moves;
	}
	
	public void setPuzzle(Puzzle p) {
		puzzle = p; 
	}
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	public void setSelectedPieceOne(NumberPiece p) {
		selectedPieceOne = p;
	}
	public NumberPiece getSelectedPieceOne() {
		return selectedPieceOne; 
	}
	
	public void clearSelectedPieceOne(NumberPiece p) {
		selectedPieceOne = null;
	}

	
	public boolean isGameOver() {
		return gameOver; 
	}
	
	public void setGameOver(boolean flag) {
		gameOver = flag;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public void resetPuzzle() {
		puzzle.reset();
		selectedPieceOne = null;
		numMoves = 0;
		gameOver = false;
	}
	
	

}
