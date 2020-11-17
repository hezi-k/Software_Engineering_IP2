package numberpuzzle.controller;

import java.awt.Point;
import java.util.List;

import numberpuzzle.boundary.NumberPuzzleApp;
import numberpuzzle.boundary.UpdateButtons;
import numberpuzzle.model.Coordinate;
import numberpuzzle.model.Model;
import numberpuzzle.model.MoveType;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

public class SelectPieceController {
	
	Model model;
	NumberPuzzleApp app;
	
	public SelectPieceController(Model m, NumberPuzzleApp a) {
		this.model = m;
		this.app = a;
		
	}
	
	public void processOne(Point point) {
		
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();
		
		
		for(NumberPiece p : puzzle) { 
			if(p.contains(c)) {
				model.clearSelectedPieceOne(p);
				model.setSelectedPieceOne(p);
				//System.out.println("Selected Piece is:" + p.number);
				//System.out.println(puzzle.operation(new Coordinate(p.getColumn(), p.getRow() - 1)));
				List<MoveType> moves = model.availableMoves(p);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
		
	}	
	

}
