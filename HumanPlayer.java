/*
 * This class contains the setters and getters for every 
 * required detail of a Human player
 * @author Abhishek Sirohi
 * @Student Id 727644
 */
public class HumanPlayer extends Player {

	/* This is the constructor that is initializing every setter. */
	public HumanPlayer() {
		setusername("");
		setgivenname("");
		setfamilyname("");
		setgamesplayed(0);
		setGameswon(0);
		setGamesdraw(0);
		setwinrate(0.0);
		setdrawrate(0.0);
	}

	Move hmove = new Move(0, 0);

	public void setgivenname(String Gname) {
		super.setgivenname(Gname);
	}

	public String getgivenname() {
		return super.getgivenname();
	}

	public void setfamilyname(String Fname) {
		super.setfamilyname(Fname);
	}

	public String getfamilyname() {
		return super.getfamilyname();
	}

	public void setusername(String Uname) {
		super.setusername(Uname);
	}

	public String getusername() {
		return super.getusername();
	}

	public void setgamesplayed(int gplayed) {
		super.setgamesplayed(gplayed);
	}

	public int getgamesplayed() {
		return super.getgamesplayed();
	}

	public void setGameswon(int gwon) {
		super.setGameswon(gwon);
	}

	public int getGameswon() {
		return super.getGameswon();
	}

	public void setGamesdraw(int gdraw) {
		super.setGamesdraw(gdraw);
	}

	public int getGamesdraw() {
		return super.getGamesdraw();
	}

	public void setwinrate(double rate) {
		super.setwinrate(rate);
	}

	public double getwinrate() {
		// TODO Auto-generated method stub
		return super.getwinrate();
	}

	public void setdrawrate(double rate) {

		super.setdrawrate(rate);
	}

	public double getdrawrate() {
		// TODO Auto-generated method stub
		return super.getdrawrate();
	}

	/*
	 * This is the abstract method present in Player class that is used to
	 * calculate a move for the human player
	 */

	public Move makeMove(char[][] gameBoard) {

		boolean flag = false;
		while (!flag) {
			String hInput = TicTacToe.keyboard.nextLine();
			String input[] = hInput.split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			if (row < 0 || row > 2 && col < 0 || col > 2) {
				System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
			} else if (gameBoard[row][col] != ' ') {
				System.out.println("Invalid move. The cell has been occupied.");
			} else {
				hmove.setRow(row);
				hmove.setCol(col);
				flag = true;
			}
		}
		return hmove;
	}
}
