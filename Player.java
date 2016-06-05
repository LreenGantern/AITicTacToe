/*
 * This class contains the setters and getters for every 
 * required detail of a player
 * @author Abhishek Sirohi
 * @Student Id 727644
 */
public abstract class Player {

	private String username;
	private String givenname;
	private String familyname;
	private int gamesplayed;
	private int gameswon;
	private int gamesdraw;
	private double winrate;
	private double drawrate;

	public Player()
	{
		setusername("");
		setgivenname("");
		setfamilyname("");
		setgamesplayed(0);
		setGameswon(0);
		setGamesdraw(0);
		setwinrate(0.0);
		setdrawrate(0.0);
	}

	
	public void setgivenname(String Gname) {
		givenname = Gname;
	}

	public String getgivenname() {
		return givenname;
	}

	public void setfamilyname(String Fname) {
		familyname = Fname;
	}

	public String getfamilyname() {
		return familyname;
	}

	public void setusername(String Uname) {
		username = Uname;
	}

	public String getusername() {
		return username;
	}

	public void setgamesplayed(int gplayed) {
		gamesplayed = gplayed;
	}

	public int getgamesplayed() {
		return gamesplayed;
	}

	public void setGameswon(int gwon) {
		gameswon = gwon;
	}

	public int getGameswon() {
		return gameswon;
	}

	public void setGamesdraw(int gdraw) {
		gamesdraw = gdraw;
	}

	public int getGamesdraw() {
		return gamesdraw;
	}

	public double getwinrate() {
		// TODO Auto-generated method stub
		return winrate;
	}

	public void setwinrate(double rate) {
		 winrate = rate;
	}

	public void setdrawrate(double rate) {

		 drawrate = rate;
	}

	public double getdrawrate() {
		// TODO Auto-generated method stub
		return drawrate;
	}
	public abstract Move makeMove(char[][] gameBoard);
}
