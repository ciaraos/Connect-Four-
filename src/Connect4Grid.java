
public interface Connect4Grid {
/*Connect4Grid interface
An interface with the following (abstract) methods:  */
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();
}
