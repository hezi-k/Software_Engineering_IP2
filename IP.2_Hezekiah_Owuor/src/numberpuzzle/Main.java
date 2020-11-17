package numberpuzzle;

import numberpuzzle.boundary.NumberPuzzleApp;
import numberpuzzle.model.Model;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

public class Main {
	
	public static void main(String[] args) {
		Model m = new Model();
		
		Puzzle puzzle = new Puzzle(3, 3);
		NumberPiece p1 = new NumberPiece(1, 1, 3);
		NumberPiece p2 = new NumberPiece(1, 1, 9);
		NumberPiece p3 = new NumberPiece(1, 1, 4);
		NumberPiece p4 = new NumberPiece(1, 1, 6);
		NumberPiece p5 = new NumberPiece(1, 1, 1);
		NumberPiece p6 = new NumberPiece(1, 1, 5);
		NumberPiece p7 = new NumberPiece(1, 1, 8);
		NumberPiece p8 = new NumberPiece(1, 1, 2);
		NumberPiece p9 = new NumberPiece(1, 1, 7);
		
		puzzle.addPiece(p1, 0, 0);
		puzzle.addPiece(p2, 0, 1);
		puzzle.addPiece(p3, 0, 2);
		puzzle.addPiece(p4, 1, 0);
		puzzle.addPiece(p5, 1, 1);
		puzzle.addPiece(p6, 1, 2);
		puzzle.addPiece(p7, 2, 0);
		puzzle.addPiece(p8, 2, 1);
		puzzle.addPiece(p9, 2, 2);
		
		m.setPuzzle(puzzle);
		
		NumberPuzzleApp app = new NumberPuzzleApp(m);
		app.setVisible(true);
	}
	
}
