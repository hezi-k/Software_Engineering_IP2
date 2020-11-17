package numberpuzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

class TestPuzzle {

	@Test
	void testIsolatedPieceTrue() {
		
		Puzzle puzzle = new Puzzle(3, 3);
		
		NumberPiece piece = new NumberPiece(1, 1, 9);
		NumberPiece piece1 = new NumberPiece(1, 1, 0);
		NumberPiece piece2 = new NumberPiece(1, 1, 0);
		NumberPiece piece3 = new NumberPiece(1, 1, 0);
		NumberPiece piece4 = new NumberPiece(1, 1, 0);

		puzzle.addPiece(piece, 1, 1);
		puzzle.addPiece(piece1, 1, 0);
		puzzle.addPiece(piece2, 1, 2);
		puzzle.addPiece(piece3, 0, 1);
		puzzle.addPiece(piece4, 2, 1);
		
		assertTrue(puzzle.checkIfIsolated(puzzle));
		
	}
	
	@Test
	void testIsolatedPieceFalse() {
		
		Puzzle puzzle1 = new Puzzle(3, 3);
		
		NumberPiece piece5 = new NumberPiece(1, 1, 9);
		NumberPiece piece6 = new NumberPiece(1, 1, 4);
		NumberPiece piece7 = new NumberPiece(1, 1, 3);
		NumberPiece piece8 = new NumberPiece(1, 1, 2);
		NumberPiece piece9 = new NumberPiece(1, 1, 1);

		puzzle1.addPiece(piece5, 1, 1);
		puzzle1.addPiece(piece6, 1, 0);
		puzzle1.addPiece(piece7, 1, 2);
		puzzle1.addPiece(piece8, 0, 1);
		puzzle1.addPiece(piece9, 2, 1);

		
		assertFalse(puzzle1.checkIfIsolated(puzzle1));
	}
	
	@Test
	void testWinConditionFalse() {
		
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
		
		assertFalse(puzzle.winCondition(puzzle));
		
	}
	
	@Test
	void testWinConditionTrue() {
		
		Puzzle puzzle = new Puzzle(3, 3);
		NumberPiece p1 = new NumberPiece(1, 1, 0);
		NumberPiece p2 = new NumberPiece(1, 1, 0);
		NumberPiece p3 = new NumberPiece(1, 1, 0);
		NumberPiece p4 = new NumberPiece(1, 1, 0);
		NumberPiece p5 = new NumberPiece(1, 1, 1);
		NumberPiece p6 = new NumberPiece(1, 1, 0);
		NumberPiece p7 = new NumberPiece(1, 1, 0);
		NumberPiece p8 = new NumberPiece(1, 1, 0);
		NumberPiece p9 = new NumberPiece(1, 1, 0);
		
		puzzle.addPiece(p1, 0, 0);
		puzzle.addPiece(p2, 0, 1);
		puzzle.addPiece(p3, 0, 2);
		puzzle.addPiece(p4, 1, 0);
		puzzle.addPiece(p5, 1, 1);
		puzzle.addPiece(p6, 1, 2);
		puzzle.addPiece(p7, 2, 0);
		puzzle.addPiece(p8, 2, 1);
		puzzle.addPiece(p9, 2, 2);
		
		assertTrue(puzzle.winCondition(puzzle));
		
	}
	
	@Test
	void testModify() {
		
		Puzzle puzzle = new Puzzle(3, 3);
		NumberPiece p1 = new NumberPiece(1, 1, 0);
		puzzle.addPiece(p1, 0, 0);
		
		puzzle.modifyPiece(p1, 3);
			
		assertEquals(3,p1.number);
	
		
	}

}
