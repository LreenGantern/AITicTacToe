import java.util.Scanner;
/*
 * This class contains the logic for playing the game.
 * @author Abhishek Sirohi
 * @Student Id 727644
 */

public class GameManager {
	Scanner keyboard = new Scanner(System.in);
	public static int k = 0;
	private String playerO;
	private String playerX;
	public char board[][] = new char[3][3];
	String mve[] = { "0 0", "0 1", "0 2", "1 0", "1 1", "1 2", "2 0", "2 1", "2 2" };
	HumanPlayer hp = new HumanPlayer();
	AIPlayer ai = new AIPlayer();

	/*
	 * The playGame method takes two strings and the type of the strings (i.e
	 * whether the string is a Human player or an AI player) as its input (the
	 * two players' user names) and has the logic for the changing the move.
	 */

	public int playGame(String play1, String play2, int type1, int type2) {
		int valueReturned = 0;
		initGame();
		printBoard();
		for (int i = 0; i < 9; i++) {

			/* Both the players are Human */

			if (type1 == 0 && type2 == 0) {
				String playerOT[] = play1.split(" ");
				playerO = playerOT[1];
				String playerXT[] = play2.split(" ");
				playerX = playerXT[1];
				while (!(getGameState() == 2 || getGameState() == 1 || isFull())) {
					System.out.println(playerO + "'s move:");
					Move human1 = hp.makeMove(board);
					Integer rows = human1.getRow();
					Integer col = human1.getCol();
					String r = rows.toString();
					String c = col.toString();
					String oMove = r + " " + c;

					updateOMoveO(oMove);
					printBoard();
					int a = getGameState();
					if (checkIfMatchOver(a) == true) {
						break;
					}

					System.out.println(playerX + "'s move:");
					Move human2 = hp.makeMove(board);
					Integer rows2 = human2.getRow();
					Integer col2 = human2.getCol();
					String r2 = rows2.toString();
					String c2 = col2.toString();
					String xMove = r2 + " " + c2;

					updateOMoveX(xMove);
					printBoard();
					int b = getGameState();
					if (checkIfMatchOver(b) == true) {
						break;
					}
				}
			}

			/* Both the players are AI */

			if (type1 == 1 && type2 == 1) {
				playerO = play1;
				playerX = play2;
				while (!(getGameState() == 2 || getGameState() == 1 || isFull())) {
					System.out.println(playerO + "'s move:");
					Move comp1 = ai.makeMove(board);
					Integer rows = comp1.getRow();
					Integer col = comp1.getCol();
					String r = rows.toString();
					String c = col.toString();
					String oMove = r + " " + c;

					updateOMoveO(oMove);
					printBoard();
					int a = getGameState();
					if (checkIfMatchOver(a) == true) {
						break;
					}

					System.out.println(playerX + "'s move:");
					Move comp2 = ai.makeMove(board);
					Integer rows2 = comp2.getRow();
					Integer col2 = comp2.getCol();
					String r2 = rows2.toString();
					String c2 = col2.toString();
					String xMove = r2 + " " + c2;

					updateOMoveX(xMove);
					printBoard();
					int b = getGameState();
					if (checkIfMatchOver(b) == true) {
						break;
					}
				}
			}

			/* Player 1 is an AI and Player 2 is a Human */ 

			if (type1 == 1 && type2 == 0) {
				playerO = play1;
				String playerXT[] = play2.split(" ");
				playerX = playerXT[1];
				while (!(getGameState() == 2 || getGameState() == 1 || isFull())) {
					System.out.println(playerO + "'s move:");
					Move comp1 = ai.makeMove(board);
					Integer rows = comp1.getRow();
					Integer col = comp1.getCol();
					String r = rows.toString();
					String c = col.toString();
					String oMove = r + " " + c;

					updateOMoveO(oMove);
					printBoard();
					int a = getGameState();
					if (checkIfMatchOver(a) == true) {
						break;
					}

					System.out.println(playerX + "'s move:");
					Move human2 = hp.makeMove(board);
					Integer rows2 = human2.getRow();
					Integer col2 = human2.getCol();
					String r2 = rows2.toString();
					String c2 = col2.toString();
					String xMove = r2 + " " + c2;

					while (isValidPos(xMove) == false || playerAtPos(xMove) != ' ') {
						if (isValidPos(xMove) == false) {
							System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
						} else if (playerAtPos(xMove) != ' ') {
							System.out.println("Invalid move. The cell has been occupied.");
						}
						System.out.println(playerX + "'s move:");
						rows2 = human2.getRow();
						col2 = human2.getCol();
						r2 = rows2.toString();
						c2 = col2.toString();
						xMove = r2 + " " + c2;
					}
					updateOMoveX(xMove);
					printBoard();
					int b = getGameState();
					if (checkIfMatchOver(b) == true) {
						break;
					}
				}
			}
			/* Player 1 is a Human and Player 2 is an AI */

			if (type1 == 0 && type2 == 1) {
				String playerOT[] = play1.split(" ");
				playerO = playerOT[1];
				playerX = play2;
				while (!(getGameState() == 2 || getGameState() == 1 || isFull())) {
					System.out.println(playerO + "'s move:");
					Move human1 = hp.makeMove(board);
					Integer rows = human1.getRow();
					Integer col = human1.getCol();
					String r = rows.toString();
					String c = col.toString();
					String oMove = r + " " + c;

					while (isValidPos(oMove) == false || playerAtPos(oMove) != ' ') {
						if (isValidPos(oMove) == false)
							System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
						else if (playerAtPos(oMove) != ' ')
							System.out.println("Invalid move. The cell has been occupied.");
						System.out.println(playerO + "'s move:");
						rows = human1.getRow();
						col = human1.getCol();
						r = rows.toString();
						c = col.toString();
						oMove = r + " " + c;
					}
					updateOMoveO(oMove);
					printBoard();
					int a = getGameState();
					if (checkIfMatchOver(a) == true) {
						break;
					}
					System.out.println(playerX + "'s move:");
					Move comp2 = ai.makeMove(board);
					Integer rows2 = comp2.getRow();
					Integer col2 = comp2.getCol();
					String r2 = rows2.toString();
					String c2 = col2.toString();
					String xMove = r2 + " " + c2;

					updateOMoveX(xMove);
					printBoard();
					int b = getGameState();
					if (checkIfMatchOver(b) == true) {
						break;
					}
				}
			}
			if (getGameState() == 1) {
				System.out.println("Game over. " + playerO + " won!");
				valueReturned = 1;
				break;
			}
			if (getGameState() == 2) {
				System.out.println("Game over. " + playerX + " won!");
				valueReturned = 2;
				break;
			}
			if (getGameState() == 3) {
				System.out.println("Game over. It was a draw!");
				valueReturned = 3;
				break;
			}
		}

		if (valueReturned != 0) {
			return valueReturned;
		} else {
			return 0;
		}
	}

	/* The updateOMoveX method updates the board with playerX's choice of input. */
	
	private void updateOMoveX(String xMov) {
		char[] xMove = xMov.toCharArray();
		// TODO Auto-generated method stub
		if (xMove[0] == '0' && xMove[2] == '0') {
			board[0][0] = 'X';
		}
		if (xMove[0] == '0' && xMove[2] == '1') {
			board[0][1] = 'X';
		}
		if (xMove[0] == '0' && xMove[2] == '2') {
			board[0][2] = 'X';
		}
		if (xMove[0] == '1' && xMove[2] == '0') {
			board[1][0] = 'X';
		}
		if (xMove[0] == '1' && xMove[2] == '1') {
			board[1][1] = 'X';
		}
		if (xMove[0] == '1' && xMove[2] == '2') {
			board[1][2] = 'X';
		}
		if (xMove[0] == '2' && xMove[2] == '0') {
			board[2][0] = 'X';
		}
		if (xMove[0] == '2' && xMove[2] == '1') {
			board[2][1] = 'X';
		}
		if (xMove[0] == '2' && xMove[2] == '2') {
			board[2][2] = 'X';
		}
	}

	/* The updateOMove0 method updates the board with playerO's choice of input. */ 

	public void updateOMoveO(String oMov) {
		// TODO Auto-generated method stub
		char oMove[] = oMov.toCharArray();

		if (oMove[0] == '0' && oMove[2] == '0') {
			board[0][0] = 'O';
		}
		if (oMove[0] == '0' && oMove[2] == '1') {
			board[0][1] = 'O';
		}
		if (oMove[0] == '0' && oMove[2] == '2') {
			board[0][2] = 'O';
		}
		if (oMove[0] == '1' && oMove[2] == '0') {
			board[1][0] = 'O';
		}
		if (oMove[0] == '1' && oMove[2] == '1') {
			board[1][1] = 'O';
		}
		if (oMove[0] == '1' && oMove[2] == '2') {
			board[1][2] = 'O';
		}
		if (oMove[0] == '2' && oMove[2] == '0') {
			board[2][0] = 'O';
		}
		if (oMove[0] == '2' && oMove[2] == '1') {
			board[2][1] = 'O';
		}
		if (oMove[0] == '2' && oMove[2] == '2') {
			board[2][2] = 'O';
		}
	}

	/* printBoard method prints the board */
	public void printBoard() {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("------");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("------");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}

	/* initGame method initializes the game */
	
	public void initGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/*isFull method checks if the board is full*/
	
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	/* getGameState method returns the current state of the board */ 
	public int getGameState() {
		int Won1 = 1;
		int Won2 = 2;
		int draw = 3;
		int continueProg = 4;
		// ROWS
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
			if (board[0][0] == 'O') {
				return Won1;
			} else if (board[0][0] == 'X') {
				return Won2;
			}
		}
		if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
			if (board[1][0] == 'O') {
				return Won1;
			} else if (board[1][0] == 'X') {
				return Won2;
			}
		}
		if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
			if (board[2][0] == 'O') {
				return Won1;
			} else if (board[2][0] == 'X') {
				return Won2;
			}
		}
		// COLUMNS
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
			if (board[0][0] == 'O') {
				return Won1;
			} else if (board[0][0] == 'X') {
				return Won2;
			}
		}
		if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
			if (board[0][1] == 'O') {
				return Won1;
			} else if (board[0][1] == 'X') {
				return Won2;
			}
		}
		if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
			if (board[0][2] == 'O') {
				return Won1;
			} else if (board[0][2] == 'X') {
				return Won2;
			}
		}
		// DIAGONALS
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if (board[0][0] == 'O') {
				return Won1;
			} else if (board[0][0] == 'X') {
				return Won2;
			}
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if (board[0][2] == 'O') {
				return Won1;
			} else if (board[0][2] == 'X') {
				return Won2;
			}
		}
		if (isFull()) {
			return draw;
		}
		return continueProg;
	}

	/* This Function checks whether the position is valid or not */
	
	public boolean isValidPos(String move) {
		String split[] = move.split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);

		if (0 <= x && x <= 2 && 0 <= y && y <= 2) {
			return true;
		} else
			return false;
	}

	/* This Function checks whether the position is empty or not */
	
	public char playerAtPos(String move) {
		String split[] = move.split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		if (isValidPos(move)) {
			return board[x][y];
		} else
			return 'N';
	}

	/* This function checks whether the match is over or not */
	
	public boolean checkIfMatchOver(int a) {
		if (a == 1 || a == 2) {
			return true;
		} else
			return false;
	}
}
