import java.util.Random;
import java.util.Scanner;

public class C4RandomAIPlayer extends ConnectPlayer{
	/*
	 * C4RandomAIPlayer class A class which extends the ConnectPlayer abstract class
	 * and whose objects represent Random AI Player (a computer) which is involved
	 * in a Connect Four game.
	 */
	private char comPlayerPiece;
	public C4RandomAIPlayer(char comPlayerPiece) {
		super();
		this.comPlayerPiece = comPlayerPiece;
	}
	public char getComPlayerPiece() {
		return comPlayerPiece;
	}
	@Override
	public int playerColumn() {
		Random comColumn = new Random();
		int nextComColumn = comColumn.nextInt(7);
		return nextComColumn;
	}
}
