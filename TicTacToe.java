
/*
 * This class contains the commands directives upon which the program has to act.
 * It contains the run method which has all the commands and the directives.
 * @author Abhishek Sirohi 
 * @Student Id 727644
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TicTacToe {
	private static PlayerManager game;						 		 // Object of the PlayerManager class
	private static GameManager playgame;							 // Object of the GameManager class
	public static final Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws UserException {
		game = new PlayerManager();
		playgame = new GameManager();
		game.readdata();
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println();

		System.out.print(">");

		TicTacToe gamesystem = new TicTacToe();
		gamesystem.run();
	}

	public void run() throws UserException {

		while (true) {
			String text = null;
			try {
				text = keyboard.nextLine();
			} catch (NoSuchElementException e) {

			}

			String arr[] = text.split(" ", 2);

			/*
			 * Checking for the valid commands, which would be entered by the
			 * user at the command line
			 */

			try {
				if ((arr[0].equals("addplayer") || arr[0].equals("displayplayer") || arr[0].equals("resetstats")
						|| arr[0].equals("rankings") || arr[0].equals("removeplayer") || arr[0].equals("exit")
						|| arr[0].equals("editplayer") || arr[0].equals("playgame")
						|| arr[0].equals("addaiplayer")) == false)
					throw (new UserException(arr[0]));

				/* Directive to add a new player */

				if (arr[0].equals("addplayer")) {
					String newstr = arr[1];
					String array[] = newstr.split(",");
					try {
						if (array.length != 3)
							throw (new UserException());

						else {
							game.addplayer(array[0], array[1], array[2]);
							System.out.println();
							System.out.print(">");
						}
					} catch (UserException a) {
					}

				}

				/* Directive to display a player */

				if (arr[0].equals("displayplayer")) {

					if (arr.length == 1) {
						game.displayallplayers();
					} else {
						String newstr = arr[1];
						String array[] = newstr.split(",");
						if (array.length > 1) {
							throw (new UserException());
						} else if (array.length == 1) {
							String username = array[0];
							game.displayplayer(username);
						}
					}
					System.out.println();
					System.out.print(">");
				}

				/* Directive to exit the program */

				if (arr[0].equals("exit")) {
					if (arr.length != 1) {
						throw (new UserException());
					} else {
						game.writedata();
						System.out.println(" ");
						System.exit(0);
					}
				}

				/*
				 * Directive to reset the statistics of any or all of the
				 * players
				 */

				if (arr[0].equals("resetstats")) {
					if (arr.length < 2) {
						System.out.println("Are you sure you want to reset all player statistics? (y/n)");
						String reply = keyboard.nextLine();
						game.resetallplayers(reply);
					} else if (arr.length > 2) {
						throw (new UserException());
					} else if (arr.length == 2) {
						String username = arr[1];
						game.resetplayer(username);
					}
					System.out.println();
					System.out.print(">");
				}

				/* Directive to edit the information of any player */

				if (arr[0].equals("editplayer")) {
					String newstr = arr[1];
					String array[] = newstr.split(",");
					try {
						if (array.length != 3)
							throw (new UserException());
						else {
							game.editplayer(array[0], array[1], array[2]);
							System.out.println();
							System.out.print(">");
						}
					} catch (Exception a) {
					}
				}

				/* Directive to remove any or all the players */

				if (arr[0].equals("removeplayer")) {
					if (arr.length < 2) {
						System.out.println("Are you sure you want to remove all players? (y/n)");
						if (keyboard.nextLine().equals("y")) {
							game.removeallplayer(0);
						}

					} else {
						String username = arr[1];
						game.removeplayer(username);

					}
					System.out.println();
					System.out.print(">");
				}

				/* Directive to display the rankings */

				if (arr[0].equals("rankings")) {
					game.rankings();

					System.out.println(" ");
					System.out.println();
					System.out.print(">");
				}

				/* Directive to play the game */

				if (arr[0].equals("playgame")) {
					String d1 = " ";
					String d2 = ",";
					String input = text.replaceAll(d2, d1);
					String ar[] = input.split(" ");
					String player1 = ar[1];
					String player2 = ar[2];
					try {
						if (game.lookup(player1, player2) == 0) {
							System.out.println("Player does not exist.");
						} else {
							String givenname1 = game.getGivenName(player1);
							String givenname2 = game.getGivenName(player2);
							int type1 = checkType(givenname1);
							int type2 = checkType(givenname2);
							int result = playgame.playGame(givenname1, givenname2, type1, type2);
							game.update(player1, player2, result);
						}
					} catch (Exception a) {
						a.printStackTrace();
					}
					System.out.println();
					System.out.print(">");
				}

				/* Directive to add a new AI player */

				if (arr[0].equals("addaiplayer")) {
					String newstr = arr[1];
					String array[] = newstr.split(",");
					try {
						if (array.length != 3)
							throw (new UserException());
						else {
							game.addaiplayer(array[0], array[1], array[2]);
							System.out.println();
							System.out.print(">");
						}
					} catch (UserException a) {
					}
				}
			} catch (UserException e) {
				e.getMessage();
			}
		}
	}

	/*
	 * Method to check whether the givenname belogs to a humna player or an AI
	 * player
	 */

	private int checkType(String givenname) {
		// TODO Auto-generated method stub
		String name = givenname;
		int k = 0;
		if (name.contains("(Human)")) {
			k = 0;
		} else {
			k = 1;
		}
		return k;
	}
}
