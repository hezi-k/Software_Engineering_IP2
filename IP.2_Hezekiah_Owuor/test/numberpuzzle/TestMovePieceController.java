package numberpuzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import numberpuzzle.boundary.NumberPuzzleApp;
import numberpuzzle.boundary.PuzzlePanel;
import numberpuzzle.controller.MoveTileController;
import numberpuzzle.controller.SelectPieceController;
import numberpuzzle.model.Coordinate;
import numberpuzzle.model.Model;
import numberpuzzle.model.MoveType;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

class TestMovePieceController {
	
	Model model = new Model();
	
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
	
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2, c.row * PuzzlePanel.boxSize + PuzzlePanel.boxSize/2);
	}

	@Test
	void test() {
		
		puzzle.addPiece(p1, 0, 0);
		puzzle.addPiece(p2, 0, 1);
		puzzle.addPiece(p3, 0, 2);
		puzzle.addPiece(p4, 1, 0);
		puzzle.addPiece(p5, 1, 1);
		puzzle.addPiece(p6, 1, 2);
		puzzle.addPiece(p7, 2, 0);
		puzzle.addPiece(p8, 2, 1);
		puzzle.addPiece(p9, 2, 2);
		
		model.setPuzzle(puzzle);
		app.setVisible(true);
		
		SelectPieceController spc = new SelectPieceController(model, app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		
		//assertEquals(new Coordinate(1,1), app.getPuzzlePanel().pointToCoordinate(pt));
		
		spc.processOne(pt);
		
		MoveTileController mpc = new MoveTileController(model, app);
		assertTrue(mpc.moveTile(MoveType.Left, puzzle));
		
		app.setVisible(false);
	}

}
