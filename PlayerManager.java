import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * This class contains all the methods which are necessary for the basic operations for the game.
 * The TicTacToe class the methods of this class using PlayerManager's object "game".
 * @author Abhishek Sirohi
 * @Student Id 727644
 */
public class PlayerManager {
	Player player;
	static int size = 0;
	HumanPlayer[] humArr = new HumanPlayer[100]; // HumanPlayer class's object
													// array.
	AIPlayer[] AiArr = new AIPlayer[100]; // AIPlayer class's object array.
	private static String[] username = new String[100]; // Array to store the
														// user names.
	private static String[] givenname = new String[100]; // Array to store the
															// given names.
	private static String[] familyname = new String[100]; // Array to store the
															// family names.
	private static int[] gamesplayed = new int[100]; // Array to store the
														// number of games
														// played.
	private static int[] gameswon = new int[100]; // Array to store the number
													// of games win.
	private static int[] gamesdraw = new int[100]; // Array to store the number
													// of drawn games.
	private static double[] winrate = new double[100]; // Array to store the win
														// rate.
	private static double[] drawrate = new double[100]; // Array to store the
														// draw rate.
	Boolean temp = false;

	/* Initializing the arrays */

	public PlayerManager() {
		for (int i = 0; i < humArr.length; i++) {
			humArr[i] = new HumanPlayer();
			AiArr[i] = new AIPlayer();
			username[i] = null;
			givenname[i] = null;
			familyname[i] = null;
			gamesplayed[i] = 0;
			gameswon[i] = 0;
			gamesdraw[i] = 0;
			winrate[i] = 0;
			drawrate[i] = 0;
		}
	}

	/* This function adds new players */

	public void addplayer(String usernme, String familynme, String givennme) {
		int k = 0;
		for (int j = 0; j < size; j++) {
			if (usernme.equals(username[j])) {
				k = 1;
				System.out.println("The username has been used already.");
			}
		}
		if (k == 0) {
			humArr[size] = new HumanPlayer();
			humArr[size].setusername(usernme);
			humArr[size].setfamilyname(familynme);
			humArr[size].setgivenname("(Human) " + givennme);
			humArr[size].setGameswon(0);
			humArr[size].setgamesplayed(0);
			humArr[size].setGamesdraw(0);
			humArr[size].setwinrate(0.0);
			humArr[size].setdrawrate(0.0);
			username[size] = usernme;
			givenname[size] = "(Human) " + givennme;
			familyname[size] = familynme;
			gamesplayed[size] = 0;
			gameswon[size] = 0;
			gamesdraw[size] = 0;
			winrate[size] = 0.0;
			drawrate[size] = 0.0;
			size = size + 1;
		}
	}

	/* This function removes a player from the system */

	public void removeplayer(String usernme) {
		boolean temp = false;
		int index = 0;
		for (int j = 0; j < size; j++) {
			if (username[j].equals(usernme)) {
				index = j;
				temp = true;
				break;
			}
		}
		if (temp == true) {
			String name = givenname[index];
			String[] nme = name.split(" ");
			if (nme[0] == "(Human)") {
				humArr[index] = humArr[index + 1];
				int xchng = size - (index + 1);
				System.arraycopy(username, index + 1, username, index, xchng);
				System.arraycopy(givenname, index + 1, givenname, index, xchng);
				System.arraycopy(familyname, index + 1, familyname, index, xchng);
				System.arraycopy(gamesplayed, index + 1, gamesplayed, index, xchng);
				System.arraycopy(gameswon, index + 1, gameswon, index, xchng);
				System.arraycopy(gamesdraw, index + 1, gamesdraw, index, xchng);
				System.arraycopy(winrate, index + 1, winrate, index, xchng);
				System.arraycopy(drawrate, index + 1, drawrate, index, xchng);
				size = size - 1;
			} else {
				AiArr[index] = AiArr[index + 1];
				int xchng = size - (index + 1);
				System.arraycopy(username, index + 1, username, index, xchng);
				System.arraycopy(givenname, index + 1, givenname, index, xchng);
				System.arraycopy(familyname, index + 1, familyname, index, xchng);
				System.arraycopy(gamesplayed, index + 1, gamesplayed, index, xchng);
				System.arraycopy(gameswon, index + 1, gameswon, index, xchng);
				System.arraycopy(gamesdraw, index + 1, gamesdraw, index, xchng);
				System.arraycopy(winrate, index + 1, winrate, index, xchng);
				System.arraycopy(drawrate, index + 1, drawrate, index, xchng);
				size = size - 1;
			}
		} else {
			System.out.println("The player does not exist.");
		}
	}

	/* This function removes all the players from the system */

	public void removeallplayer(int size) {
		for (int index = 0; index < size; index++) {
			username[index] = null;
			givenname[index] = null;
			familyname[index] = null;
			gamesplayed[index] = 0;
			gameswon[index] = 0;
			gamesdraw[index] = 0;
			winrate[index] = 0.0;
			drawrate[index] = 0.0;
		}
		PlayerManager.size = 0;
	}

	/*
	 * This function edits the given name and the family name of the players in
	 * the system
	 */

	public void editplayer(String usernme, String familynme, String givennme) {
		boolean temp = false;
		int index = 0;
		for (int j = 0; j < size; j++) {
			if (usernme.equals(username[j])) {
				temp = true;
				index = j;
			}
		}
		if (temp == true) {
			String name = givenname[index];
			String[] nme = name.split(" ");
			if (("(Human)").equals(nme[0])) {
				humArr[index].setfamilyname(familynme);
				familyname[index] = familynme;
				humArr[index].setgivenname("(Human) " + givennme);
				givenname[index] = "(Human) " + givennme;
			} else {
				AiArr[index].setfamilyname(familynme);
				familyname[index] = familynme;
				AiArr[index].setgivenname(givennme);
				givenname[index] = givennme;
			}
		} else {
			System.out.println("The player does not exist.");
		}
	}

	/* This function resets the statistics for all the players in the system */

	public void resetallplayers(String reply) {

		if (reply.equals("y")) {
			for (int j = 0; j < size; j++) {

				gamesplayed[j] = 0;
				gameswon[j] = 0;
				gamesdraw[j] = 0;
				winrate[j] = 0;
				drawrate[j] = 0;
			}
		}
	}

	/* This function resets the statistics of a single player in the system */

	public void resetplayer(String usernme) {

		boolean flag = false;
		int index = 0;
		for (int j = 0; j < size; j++) {
			if (username[j].equals(usernme)) {
				flag = true;
				index = j;
			}
		}
		if (flag == true) {
			String name = givenname[index];
			String[] nme = name.split(" ");
			if (nme[0] == "(Human)") {
				humArr[index].setgamesplayed(0);
				gamesplayed[index] = 0;
				humArr[index].setGameswon(0);
				gameswon[index] = 0;
				humArr[index].setGamesdraw(0);
				gamesdraw[index] = 0;
				humArr[index].setwinrate(0.0);
				winrate[index] = 0;
				humArr[index].setdrawrate(0.0);
				drawrate[index] = 0;
			} else {
				AiArr[index].setgamesplayed(0);
				gamesplayed[index] = 0;
				AiArr[index].setGameswon(0);
				gameswon[index] = 0;
				AiArr[index].setGamesdraw(0);
				gamesdraw[index] = 0;
				AiArr[index].setwinrate(0.0);
				winrate[index] = 0;
				AiArr[index].setdrawrate(0.0);
				drawrate[index] = 0;
			}
		} else if (flag == false) {
			System.out.println("The player does not exist.");
		}
	}

	/* This function displays all the players in the system */

	public void displayallplayers() {
		String temp[] = new String[size];
		if (size == 0) {

		} else if (size != 0) {
			for (int j = 0; j < size; j++) {
				temp[j] = username[j];
			}

			for (int k = 0; k < size; k++) {
				if (givenname[k].contains("(Human)")) {
					String[] gname = givenname[k].split(" ");
					String main = gname[1];
					System.out.println(username[k] + "," + familyname[k] + "," + main + "," + gamesplayed[k] + " games,"
							+ gameswon[k] + " wins," + gamesdraw[k] + " draws");
				} else {
					System.out.println(username[k] + "," + familyname[k] + "," + givenname[k] + "," + gamesplayed[k]
							+ " games," + gameswon[k] + " wins," + gamesdraw[k] + " draws");
				}
			}
		}
	}

	/* This function displays a specific player in the system */

	public void displayplayer(String usernme) {
		int temp = 0;
		int index = 0;
		for (int j = 0; j < size; j++) {
			if (usernme.equals(username[j])) {
				temp = 1;
				index = j;
			}
		}
		if (temp == 1) {
			if (givenname[index].contains("(Human)")) {
				String[] gname = givenname[index].split(" ");
				String main = gname[1];
				System.out.println(username[index] + "," + familyname[index] + "," + main + "," + gamesplayed[index]
						+ " games," + gameswon[index] + " wins," + gamesdraw[index] + " draws");
			} else {
				System.out.println(username[index] + "," + familyname[index] + "," + givenname[index] + ","
						+ gamesplayed[index] + " games," + gameswon[index] + " wins," + gamesdraw[index] + " draws");
			}
		} else {
			System.out.println("The player does not exist.");
		}
	}

	/* This function calculates and prints the rankings */

	public void rankings() {

		for (int j = 0; j < size; j++) {
			for (int i = j + 1; i < size; i++) {
				if (winrate[i] > (winrate[j])) {
					HumanPlayer temp = humArr[j];
					humArr[j] = humArr[i];
					humArr[i] = temp;

				} else if (winrate[i] == (winrate[j])) {

					if (username[i].compareToIgnoreCase(username[j]) < 0) {

						HumanPlayer temp = humArr[j];
						humArr[j] = humArr[i];
						humArr[i] = temp;
					}
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = j + 1; i < size; i++) {
				if (drawrate[i] > (drawrate[j])) {
					HumanPlayer temp = humArr[j];
					humArr[j] = humArr[i];
					humArr[i] = temp;
				} else if (drawrate[i] == (drawrate[j])) {

					if (username[i].compareToIgnoreCase(username[j]) < 0) {

						HumanPlayer temp = humArr[j];
						humArr[j] = humArr[i];
						humArr[i] = temp;
					}
				}
			}
		}

		System.out.print(" WIN  | DRAW | GAME | USERNAME");
		for (int i = 0; i < size; i++) {
			int wintemp = (int) winrate[i];
			int drawtemp = (int) drawrate[i];
			String win = Integer.toString(wintemp);
			String draw = Integer.toString(drawtemp);

			int gamespld = gamesplayed[i];
			String usrnme = username[i];
			System.out.printf("\n %3s%% | %3s%% | %2d   | %s", win, draw, gamespld, usrnme);

		}
	}

	/* This function calculate the win rate of a player */

	public int calculateWinrate(int gamesplayed, int gameswon) {// calculates
																// winrate
		if (gamesplayed == 0) {
			return 0;
		} else {
			double played = gamesplayed;
			double x = gameswon / played;
			double rate1 = Math.round(x * 100);
			int winRate = (int) rate1;
			return winRate;
		}
	}

	/* This function calculate the draw rate of a player */

	public int calculateDrawRate(int gamesplayed, int gamesdrawn) {
		if (gamesplayed == 0) {
			return 0;
		} else {
			double played = gamesplayed;
			double x = gamesdrawn / played;
			double rate1 = Math.round(x * 100);
			int drawRate = (int) rate1;
			return drawRate;
		}
	}

	/* This function updates the player statistics in the system */

	public void update(String playerA, String playerB, int res) {

		/* Updating the playerA's played game in the system */

		for (int i = 0; i < size; i++) {
			if (playerA.equals(username[i])) {
				if (checkType(givenname[i]) == 1) {
					humArr[i].setgamesplayed((humArr[i].getgamesplayed() + 1));
				} else {
					AiArr[i].setgamesplayed((AiArr[i].getgamesplayed() + 1));
				}
				gamesplayed[i] = gamesplayed[i] + 1;
			}
		}

		/* Updating the playerB's played game in the system */

		for (int i = 0; i < size; i++) {
			if (playerB.equals(username[i])) {
				if (checkType(givenname[i]) == 1) {
					humArr[i].setgamesplayed((humArr[i].getgamesplayed() + 1));
				} else {
					AiArr[i].setgamesplayed((AiArr[i].getgamesplayed() + 1));
				}
				gamesplayed[i] = gamesplayed[i] + 1;
			}
		}

		/* This is the condition for the playerA to win */

		if (res == 1) {

			for (int i = 0; i < size; i++) {
				if (playerA.equals(username[i])) {
					if (checkType(givenname[i]) == 1) {
						humArr[i].setGameswon((humArr[i].getGameswon() + 1));
					} else {
						AiArr[i].setGameswon((AiArr[i].getGameswon() + 1));
					}
					gameswon[i] = gameswon[i] + 1;
					winrate[i] = calculateWinrate(gamesplayed[i], gameswon[i]);
				}
			}
		}

		/* This is the condition for the playerB to win */

		if (res == 2) {

			for (int i = 0; i < size; i++) {
				if (playerB.equals(username[i])) {
					if (checkType(givenname[i]) == 1) {
						humArr[i].setGameswon((humArr[i].getGameswon() + 1));
					} else {
						AiArr[i].setGameswon((AiArr[i].getGameswon() + 1));
					}
					gameswon[i] = gameswon[i] + 1;
					winrate[i] = calculateWinrate(gamesplayed[i], gameswon[i]);
				}
			}
		}

		/* This is the condition for the playerA and playerB to draw the game */

		if (res == 3) {

			for (int i = 0; i < size; i++) {
				if (playerA.equals(username[i])) {
					if (checkType(givenname[i]) == 1) {
						humArr[i].setGamesdraw((humArr[i].getGamesdraw() + 1));
					} else {
						AiArr[i].setGamesdraw((AiArr[i].getGamesdraw() + 1));
					}
					gamesdraw[i] = gamesdraw[i] + 1;
					drawrate[i] = calculateDrawRate(gamesplayed[i], gamesdraw[i]);
				}
			}
			for (int i = 0; i < size; i++) {
				if (playerB.equals(username[i])) {
					if (checkType(givenname[i]) == 1) {
						humArr[i].setGamesdraw((humArr[i].getGamesdraw() + 1));
					} else {
						AiArr[i].setGamesdraw((AiArr[i].getGamesdraw() + 1));
					}
					gamesdraw[i] = gamesdraw[i] + 1;
					drawrate[i] = calculateDrawRate(gamesplayed[i], gamesdraw[i]);
				}
			}
		}
	}

	/* Function to get the given name by using a player's user name */

	public String getGivenName(String playerA) {
		// TODO Auto-generated method stub

		for (int i = 0; i < size; i++) {
			if (username[i].equals(playerA)) {
				return givenname[i];
			}
		}
		return "The player does not exist.";
	}

	/*
	 * This function is to check whether the two players passed as the arguments
	 * to the function are present in the system or not
	 */

	public int lookup(String playerA, String playerB) {

		// TODO Auto-generated method stub
		int flag1 = 0;
		int flag2 = 0;

		for (int i = 0; i < size; i++) {
			if (playerA.equals(username[i])) {
				flag1 = 1;
			}
		}
		for (int i = 0; i < size; i++) {
			if (playerA.equals(username[i])) {
				flag2 = 1;
			}
		}

		if ((flag1 + flag2) == 2) {
			return 1;
		}
		return 0;
	}

	/* This is a function to write player data to the file */

	public void writedata() {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileOutputStream("players.dat"));
		} catch (FileNotFoundException e) {
		}
		for (int i = 0; i < size; i++) {

			output.println(username[i] + "," + familyname[i] + "," + givenname[i] + "," + gameswon[i] + ","
					+ gamesplayed[i] + "," + gamesdraw[i]);
		}
		output.close();
	}
	/* This is a function to read player data from the file */

	public void readdata() {
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("players.dat"));
		} catch (FileNotFoundException e) {
			try {

				PrintWriter writer = new PrintWriter(new FileOutputStream("players.dat"));

			} catch (FileNotFoundException e1) {

			}
		}
		try {
			while (input.hasNext()) {

				String a = input.nextLine();
				String b[] = a.split(",");
				String c[] = b[1].split(" ");

				if (c[0] == "(Human)") {
					humArr[size] = new HumanPlayer();
					humArr[size].setusername(b[0]);
					humArr[size].setfamilyname(b[1]);
					humArr[size].setgivenname("(Human) " + b[2]);
					humArr[size].setGameswon(Integer.parseInt(b[3]));
					humArr[size].setgamesplayed(Integer.parseInt(b[4]));
					humArr[size].setGamesdraw(Integer.parseInt(b[5]));

					username[size] = b[0];
					givenname[size] = "(Human) " + b[2];
					familyname[size] = b[1];
					gamesplayed[size] = Integer.parseInt(b[4]);
					gameswon[size] = Integer.parseInt(b[3]);
					gamesdraw[size] = Integer.parseInt(b[5]);

					size = size + 1;
				} else {
					AiArr[size] = new AIPlayer();
					AiArr[size].setusername(b[0]);
					AiArr[size].setfamilyname(b[1]);
					AiArr[size].setgivenname(b[2]);
					AiArr[size].setGameswon(Integer.parseInt(b[3]));
					AiArr[size].setgamesplayed(Integer.parseInt(b[4]));
					AiArr[size].setGamesdraw(Integer.parseInt(b[5]));

					username[size] = b[0];
					givenname[size] = b[2];
					familyname[size] = b[1];
					gamesplayed[size] = Integer.parseInt(b[4]);
					gameswon[size] = Integer.parseInt(b[3]);
					gamesdraw[size] = Integer.parseInt(b[5]);

					size = size + 1;
				}
			}
		} catch (NullPointerException e) {

		}
	}

	/* This is a function to add AI players in the system */

	public void addaiplayer(String usernme, String familynme, String givennme) {
		// TODO Auto-generated method stub
		int k = 0;
		for (int j = 0; j < size; j++) {
			if (usernme.equals(username[j])) {
				k = 1;

				System.out.println("The username has been used already.");
			}
		}
		if (k == 0) {

			AiArr[size] = new AIPlayer();
			AiArr[size].setusername(usernme);
			AiArr[size].setfamilyname(familynme);
			AiArr[size].setgivenname(givennme);
			AiArr[size].setGameswon(0);
			AiArr[size].setgamesplayed(0);
			AiArr[size].setGamesdraw(0);
			AiArr[size].setwinrate(0.0);
			AiArr[size].setdrawrate(0.0);
			username[size] = usernme;
			givenname[size] = givennme;
			familyname[size] = familynme;
			gamesplayed[size] = 0;
			gameswon[size] = 0;
			gamesdraw[size] = 0;
			winrate[size] = 0.0;
			drawrate[size] = 0.0;
			size = size + 1;
		}
	}

	/*
	 * This is function to check whether the given name belongs to a Human
	 * player or an AI player
	 */

	private int checkType(String givenname) {
		// TODO Auto-generated method stub
		String name = givenname;
		int k = 0;
		if (name.contains("(Human)")) {
			k = 1;
		} else {
			k = 0;
		}
		return k;
	}
}
