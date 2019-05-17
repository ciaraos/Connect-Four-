import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	/*
	 * C4HumanPlayer class:
	 * A class which extends the ConnectPlayer abstract class
	 * and whose objects represent a human player (a user) who is involved in a
	 * Connect Four game.
	 */
	private char playerPiece;
	public C4HumanPlayer(char playerPiece) {
		super();
		this.playerPiece = playerPiece;
	}
	public char getPlayerPiece() {
		return playerPiece;
	}
	@Override
	public int playerColumn() {
		System.out.print("\n" + "Choose where to place your piece  (0 - 6) "); 
		Scanner inputScanner = new Scanner(System.in);
		int columnEntered = inputScanner.nextInt();
		return columnEntered;
	}
}
