import java.util.Scanner;

/* SELF ASSESSMENT
Connect4Game class (35 marks): 30
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 
1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialised - must specify the type to be ConnectPlayer, and 
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: I ask the user if they want to play repeatedly (there are some errors here taking in if they want to play or quit), create the board, initialize the players and check if there is a winner
Connect4Grid interface (10 marks): 10
I define all 7 methods within this interface.
Comment: I believe I did this successfully
Connect4Grid2DArray class (25 marks): 18 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: I implement the interface, there are some errors with dropping the piece as occasionally two pieces are dropped
ConnectPlayer abstract class (10 marks): 10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: I get the playerPiece (non-abstract) and the player column (abstract)
C4HumanPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: I believe my code does this
C4RandomAIPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: I believe my code does this
Total Marks out of 100: 88
*/
public class Connect4Game {
	/*
	 * Connect4Game class: A class whose objects represent an executing Connect Four
	 * two-player game application. The class will allow a user to start a new
	 * Connect Four game involving two players whose types are chosen by the user.
	 * This class consists of a mainline which handles user input. The class creates
	 * a grid using the connect4Grid interface and a human player and a computer
	 * player using the player abstract class.
	 */

	public static void main(String[] args) {
		Connect4Grid2DArray playerBoard = new Connect4Grid2DArray();
		playerBoard.emptyGrid();
		System.out.print(playerBoard.toString());
		playerBoard.didLastPieceConnect4();
		C4RandomAIPlayer comPlayer = new C4RandomAIPlayer('O');
		C4HumanPlayer player = new C4HumanPlayer('X');
		ConnectPlayer player1 = player;
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			System.out.print("\n" + "Would you like to play or quit? ");
			if (inputScanner.hasNext("play")) {
				int pickColumn = player1.playerColumn();
				System.out.println(pickColumn);
				if (playerBoard.isValidColumn(pickColumn) && !playerBoard.isColumnFull(pickColumn)) {
					playerBoard.dropPiece(player1, pickColumn);
					if (playerBoard.didLastPieceConnect4()) {
						finished = true;
						System.out.println(playerBoard.toString());
						System.out.println("WINNER");
					} else if (playerBoard.isGridFull()) {
						finished = true;
						System.out.println(playerBoard.toString());
						System.out.println("DRAW");
					} else {
						if (player1.equals(player)) {
							player1 = comPlayer;
						} else {
							player1 = player;
						}
						System.out.println(playerBoard.toString());
					}
				}
			} else if (inputScanner.hasNext("quit")) {
				System.out.print("Thanks for playing");
				finished = true;
				inputScanner.close();
			} else {
				System.out.print("Please enter a valid number (0-6) e.g. 1 ");
			}
		}
	}

}
