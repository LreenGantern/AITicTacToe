/*This is the move class which contains the getter and setters of row and column.
 * @author Abhishek Sirohi
 * @Student Id 727644
 */

public class Move {

	private int row; // Row
	private int col; // Column
	
	/* Constructor initializing the rows and columsn */

	public Move(int row, int col)

	{
		this.row = row;
		this.col = col;
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

}
