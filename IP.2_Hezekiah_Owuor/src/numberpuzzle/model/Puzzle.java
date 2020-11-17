package numberpuzzle.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<NumberPiece>{
	
	ArrayList<NumberPiece> piecesList = new ArrayList<>();
	
	ArrayList<NumberPiece> originals = new ArrayList<>();
	
	public final int numColumns;
	public final int numRows;
	
	public Puzzle(int numColumns, int numRows) {
		this.numColumns = numColumns; 
		this.numRows = numRows; 
	}
	
	public void addPiece(NumberPiece p, int column, int row) {
		p.setColumn(column);
		p.setRow(row);
		
		//check overlapping
		
		piecesList.add(p);
		originals.add(p.copy());
	}
	
	
	public void modifyPiece(NumberPiece p, int number) {
		p.setNumber(number);
	}
	
	public int operation(Coordinate c) {
		for(NumberPiece p : piecesList) {
			if(p.contains(c)) {
				return p.number;
			}
		}
		
		return -1;
	}
	
	public NumberPiece pieceAtLocation(Coordinate c) {
		
		for(NumberPiece p: piecesList) {
			if(p.contains(c)) {
				return p;
			}
		}
		
		return new NumberPiece(-1, -1, 0);
	}

	
	@Override
	public Iterator<NumberPiece> iterator() {
		return piecesList.iterator();
	}

	public void reset() {
		
		piecesList.clear();
		
		for(NumberPiece p : originals) { 
			piecesList.add(p.copy());
		}
	}
	
	public boolean winCondition(Puzzle pu) {
		
		int count = 0;
		
		for(NumberPiece p : piecesList) {
			if(p.number == 0) {
				count++;
				if(count == 8) {
					if(pu.operation(new Coordinate(1,1)) > 0) {
						return true;
					}
				}
			}
			
		}
		
		count = 0;
		
		return false;
	}
	
	public boolean checkIfIsolated(Puzzle pu) {
		
		for(NumberPiece p: piecesList) {
			if(p.isIsolated(pu)) {
				return true;
			}
		}
		
		return false;
	}

}
