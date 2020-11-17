package numberpuzzle.controller;



import numberpuzzle.boundary.NumberPuzzleApp;
import numberpuzzle.boundary.UpdateButtons;
import numberpuzzle.model.Model;

public class ResetController {
	
	Model model;
	NumberPuzzleApp app;
	
	public ResetController(Model m, NumberPuzzleApp a) {
		this.model = m;
		this.app = a;
		
	}
	
	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.availableMoves());
		app.getActualMovesLabel().setText("" + model.getNumMoves());
		app.repaint();
	}	
	

}
