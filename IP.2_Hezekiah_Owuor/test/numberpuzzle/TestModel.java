package numberpuzzle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import numberpuzzle.model.Coordinate;
import numberpuzzle.model.Model;
import numberpuzzle.model.MoveType;
import numberpuzzle.model.NumberPiece;
import numberpuzzle.model.Puzzle;

class TestModel {
	
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
	

	@Test
	void testInitialState() {
		
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
	
		assertEquals(0, model.getNumMoves());
		assertTrue (model.getSelectedPieceOne() == null);
		assertEquals (0, model.availableMoves().size());
	}
	
	@Test
	void testMove() {
		
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
		
		assertFalse (model.tryMove(MoveType.Left, puzzle));
		NumberPiece p = model.getPuzzle().pieceAtLocation(new Coordinate(1,1));
		model.setSelectedPieceOne(p);
		assertTrue(model.tryMove(MoveType.Up, puzzle));
		assertEquals(1, model.getNumMoves());
	}
	
	@Test
	void testPossibleMove() {
		
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
		
		NumberPiece p = model.getPuzzle().pieceAtLocation(new Coordinate(1,1));
		assertEquals(1, p.width);
		assertEquals(1, p.height);
		assertEquals(1, p.number);
		
		model.setSelectedPieceOne(p);
		
		List<MoveType> available = model.availableMoves();
		
		assertEquals(4, available.size());
		assertTrue(available.contains(MoveType.Left));
		assertTrue(available.contains(MoveType.Right));
		assertTrue(available.contains(MoveType.Up));
		assertTrue(available.contains(MoveType.Down));

	}
	
	@Test
	void TestBadMoves() {
		
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
		
		NumberPiece p = model.getPuzzle().pieceAtLocation(new Coordinate(1,1));
		model.setSelectedPieceOne(p);
		p.moveUp(puzzle);
		assertEquals(0, model.availableMoves().size());

		
	}
	
	@Test
	void testReset() {
		
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
		
		assertFalse (model.tryMove(MoveType.Left, puzzle));
		NumberPiece p = model.getPuzzle().pieceAtLocation(new Coordinate(1,1));
		model.setSelectedPieceOne(p);
		assertTrue (model.tryMove(MoveType.Left, puzzle));
		assertEquals(1,model.getNumMoves());
		
		model.resetPuzzle();
		assertEquals(0, model.getNumMoves());
		p = model.getPuzzle().pieceAtLocation(new Coordinate(1,1));
		assertTrue(p != null);
	}
	

}
