package numberpuzzle.model;

public class Coordinate {
	
	public final int col;
	public final int row;
	
	public Coordinate(int column, int row) {
		this.col = column;
		this.row = row;
	}
	
	public String toString() {
		return  "(" + col + "," + row + ")";
	}

}
