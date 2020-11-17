package numberpuzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import numberpuzzle.model.Coordinate;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

class TestPiece {

	@Test
	void testConstruction() {
		NumberPiece piece = new NumberPiece(1, 1, 9);
		assertEquals(1, piece.height);
		assertEquals(1, piece.width);
		assertEquals(9, piece.number);
	}
	
	@Test
	void testContains() {
		NumberPiece piece = new NumberPiece(1, 1, 9);
		piece.setColumn(2);
		piece.setRow(2);
		
		assertTrue(piece.contains(new Coordinate(2,2)));
		assertFalse(piece.contains(new Coordinate(2,1)));
		assertFalse(piece.contains(new Coordinate(1,2)));

	}
	
	@Test
	void testIsolatedPiece() {
		
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
		
		assertTrue(piece.isIsolated(puzzle));
		
		
	}
	
	@Test
	void movePiece() {
		
		Puzzle puzzle = new Puzzle(3, 3);
		
		NumberPiece piece = new NumberPiece(1, 1, 9);
		NumberPiece piece1 = new NumberPiece(1, 1, 3);
		NumberPiece piece2 = new NumberPiece(1, 2, 0);
		NumberPiece piece3 = new NumberPiece(0, 1, 0);
		NumberPiece piece4 = new NumberPiece(2, 1, 0);
		
		puzzle.addPiece(piece, 0, 0);
		puzzle.addPiece(piece1, 0, 1);
		
		piece.moveLeft(puzzle);
		
	}
	
	@Test
	void testGets() {
		
		Puzzle puzzle = new Puzzle(3, 3);
		NumberPiece piece = new NumberPiece(1, 1, 9);
		Coordinate co = new Coordinate(0,0);
		
		puzzle.addPiece(piece, 0, 0);
		
		//System.out.println(co);
		//System.out.println(piece.getCoordinate());
		
		
		
		assertEquals(9,piece.getNumber());
		assertEquals(0,piece.getColumn());
		assertEquals(0,piece.getRow());
		//assertEquals(co,piece.getCoordinate());

	}

}
