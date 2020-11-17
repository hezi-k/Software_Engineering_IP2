package numberpuzzle.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import numberpuzzle.model.Coordinate;
import numberpuzzle.model.Model;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

public class PuzzlePanel extends JPanel {
	
	Model model;
	public static final int boxSize = 100;
	public static final int offset = 2;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computeRectangle(NumberPiece p) {
		int col = p.getColumn();
		int row = p.getRow();
		
		Rectangle rect = new Rectangle(col*boxSize + offset,row*boxSize + offset,p.width*(boxSize - offset), p.height*(boxSize - offset));
		return rect;
	}
	
	public Rectangle computeResultRectangle() {
		Rectangle rect = new Rectangle(0 + offset,0 + offset,3*(boxSize + offset), 3*(boxSize - offset));
		return rect;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.x/boxSize, p.y/boxSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(model == null) {
			return;
		}
		
		Puzzle puzzle = model.getPuzzle();
		
		NumberPiece selectedPieceOne = model.getSelectedPieceOne();
		
		int alpha = 200; // 50% transparent
		
		Color myColour = new Color(255, 255, 255, alpha);
		
		for(NumberPiece p: puzzle) {
			
			if(p.equals(selectedPieceOne)) {
				g.setColor(Color.PINK);
				
			} else{
				g.setColor(Color.GRAY);
			}
			
			
			
			Rectangle r = computeRectangle(p);
			g.fillRect(r.x, r.y, r.width, r.height);
			
			g.setColor(Color.CYAN);
			g.drawString(String.valueOf(p.number), (r.x)+48, (r.y)+48);
			
			if(p.number == 0) {
				g.setColor(Color.RED);
				g.fillRect(r.x, r.y, r.width, r.height);
				g.drawString(String.valueOf(p.number), (r.x)+48, (r.y)+48);
			}
		}
		
		if(model.getPuzzle().checkIfIsolated(model.getPuzzle())) {
			System.out.println("Game Over");
			model.setGameOver(true);
			model.availableMoves();
			
			Rectangle loseRectangle = computeResultRectangle();
			
			g.setColor(myColour);
			g.fillRect(loseRectangle.x, loseRectangle.y, loseRectangle.width, loseRectangle.height + 10);
			g.setColor(Color.BLACK);
			g.drawString("Sorry! You have lost the game!", (loseRectangle.x)+50, (loseRectangle.y)+140);

		}
		
		if(model.getPuzzle().winCondition(model.getPuzzle())) {
			System.out.println("You win");
			model.setGameOver(true);
			model.availableMoves();
			
			for(NumberPiece p: puzzle) {
				if(p.number > 0) {
					Rectangle r = computeRectangle(p);
					g.setColor(Color.GREEN);
					g.fillRect(r.x, r.y, r.width, r.height);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(p.number), (r.x)+48, (r.y)+48);
				}
			}
			
			Rectangle winRectangle = computeResultRectangle();
			
			g.setColor(myColour);
			g.fillRect(winRectangle.x, winRectangle.y, winRectangle.width, winRectangle.height + 10);
			g.setColor(Color.BLACK);
			g.drawString("Great! You have won the game!", (winRectangle.x)+50, (winRectangle.y)+140);
		}
	}

}
