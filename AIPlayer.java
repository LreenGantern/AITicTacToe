
/*
 * This class contains the setters and getters for every 
 * required detail of a player
 * @author Abhishek Sirohi
 * @Student Id 727644
 */
public class AIPlayer extends Player {

	public AIPlayer() {
		setusername("");
		setgivenname("");
		setfamilyname("");
		setgamesplayed(0);
		setGameswon(0);
		setGamesdraw(0);
		setwinrate(0.0);
		setdrawrate(0.0);
	}

	Move AImove = new Move(0, 0);
	public int pos[] = new int[9];

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
	 * This is the implementation of the abstract makeMove method in the Player
	 * class
	 */

	public Move makeMove(char[][] gameBoard) {
		int rand1 = 0;
		int rand2 = 0;
		boolean flag = false;
		while (!flag) {

			rand1 = (int) (Math.random() * 3);
			rand2 = (int) (Math.random() * 3);
			if (gameBoard[rand1][rand2] != 'X' && gameBoard[rand1][rand2] != 'O') {
				AImove.setRow(rand1);
				AImove.setCol(rand2);
				flag = true;
			}
		}
		return AImove;
	}
}
