package numberpuzzle.model;

public class NumberPiece {
	
	public final int width;
	public final int height;
	public int number;
	int row;
	int column;
	
	public NumberPiece(int width, int height, int number) {
		this.width = width;
		this.height = height;
		this.number = number;
	}

	public void setRow(int r) {
		this.row = r;
	}
	
	public void setColumn(int c) {
		this.column = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int n) {
		this.number = n;
	}
	
	public Coordinate getCoordinate() {
		return new Coordinate(column, row);
	}

	public boolean contains(Coordinate c) {
		if(c.col >= column && c.col < column + width && c.row >= row && c.row < row + height) {
			return true;
		}
		
		return false;
	}
	
	public void moveRight(Puzzle p) {
		
		NumberPiece pieceToTheRight = p.pieceAtLocation(new Coordinate(this.column + 1, this.row));
		
		int num = pieceToTheRight.number;
		
		p.modifyPiece(pieceToTheRight, num+this.number);
		
		this.number = 0;
		
	}
	
	public void moveLeft(Puzzle p) {
		
		NumberPiece pieceToTheLeft = p.pieceAtLocation(new Coordinate(this.column - 1, this.row));
	
		int num = pieceToTheLeft.number;
		
		p.modifyPiece(pieceToTheLeft, num-this.number);
		
		this.number = 0;
		
	}
	
	public void moveUp(Puzzle p) {
		
		NumberPiece pieceToTheUp = p.pieceAtLocation(new Coordinate(this.column, this.row - 1));
	
		int num = pieceToTheUp.number;
		
		p.modifyPiece(pieceToTheUp, num*this.number);
		
		this.number = 0;
		
	}
	
	public void moveDown(Puzzle p) {
		
		NumberPiece pieceToTheDown = p.pieceAtLocation(new Coordinate(this.column, this.row + 1));
	
		int num = pieceToTheDown.number;
		
		p.modifyPiece(pieceToTheDown, num/this.number);
		
		this.number = 0;
		
	}

	public void move(MoveType dir, Puzzle p) {
		
		//this.row += dir.deltaR;
		//this.column += dir.deltaC;
		
		//Check if player has won
		
		if(dir == MoveType.Right) {
			moveRight(p);
		}else if(dir == MoveType.Left) {
			moveLeft(p);
		}else if(dir == MoveType.Down) {
			moveDown(p);
		}else {
			moveUp(p);
		}
		
		
		
	}

	public NumberPiece copy() {
		
		NumberPiece p = new NumberPiece(width, height, number);
		p.setRow(row);
		p.setColumn(column);
		
		return p;
		
	}
	
	public boolean isIsolated(Puzzle p) {
		
		NumberPiece pieceToTheDown = p.pieceAtLocation(new Coordinate(this.column, this.row + 1));
		NumberPiece pieceToTheUp = p.pieceAtLocation(new Coordinate(this.column, this.row - 1));
		NumberPiece pieceToTheLeft = p.pieceAtLocation(new Coordinate(this.column - 1, this.row));
		NumberPiece pieceToTheRight = p.pieceAtLocation(new Coordinate(this.column + 1, this.row));
		
		if(this.number > 0) {
			if((pieceToTheDown.number == 0 || pieceToTheDown.number == -1) &&
					(pieceToTheUp.number == 0 || pieceToTheUp.number == -1) &&
						(pieceToTheLeft.number == 0 || pieceToTheLeft.number == -1) &&
							(pieceToTheRight.number == 0 || pieceToTheRight.number == -1)) {
				return true;
			}
		}
		
		
		return false;
	}
}
