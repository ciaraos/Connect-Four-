
public abstract class ConnectPlayer {
	/*
	 * ConnectPlayer abstract class:
	 *  An abstract class that provides the operations (methods) which any type of Connect Four Player class must override.
	 */
	
	private char playerPiece;
	ConnectPlayer(){
	}
	public abstract int playerColumn();
	public char getPlayerPiece() {
		return playerPiece;
	}
}
