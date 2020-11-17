package numberpuzzle.controller;

import java.util.ArrayList;

import numberpuzzle.boundary.NumberPuzzleApp;
import numberpuzzle.boundary.UpdateButtons;
import numberpuzzle.model.Model;
import numberpuzzle.model.MoveType;
import numberpuzzle.model.Puzzle;

public class MoveTileController {
	
	Model model;
	NumberPuzzleApp app;
	
	public MoveTileController(Model m, NumberPuzzleApp a) {
		this.model = m;
		this.app = a;
	}
	
	public boolean moveTile(MoveType dir, Puzzle a) {
		
		if(model.getSelectedPieceOne() == null) {
			return false;
		}
		
		if(model.tryMove(dir, a)) {
			
			ArrayList<MoveType> moves = new ArrayList<>();
			moves.add(dir);
			UpdateButtons.enableButtons(app, moves);
			app.getActualMovesLabel().setText("" + model.getNumMoves());
			app.repaint();
		}
		
		return true; 
	}
	

}
