
public class Tile {
	
	private int row, col, room;
	private char type;
	
	public Tile(int row, int col, char type, int room) {
		super();
		this.row = row;
		this.col = col;
		this.type = type;
		this.room = room;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	public int getRoom() {
		return room;
	}
	
}
