
public class Connect4Grid2DArray {
	/*
	 * Connect4Grid2DArray class This class implements the Connect4Grid interface
	 * and provides appropriate functionality for each of the methods in the
	 * interface
	 */
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	public char[][] board = new char[ROWS][COLUMNS];

	public void emptyGrid() {
		for (int currentRow = 0; currentRow < board.length; currentRow++) {
			for (int currentCol = 0; currentCol < board[currentRow].length; currentCol++) {
				board[currentRow][currentCol] = ' ';
			}
		}
	}

	public String toString() {
		String displayBoard = " ";
		displayBoard += "\n" + "   0" + "   1 " + "  2 " + "  3 " + "  4 " + "  5 " + "  6 ";
		displayBoard += "\n" + "0  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | "
				+ board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6];
		displayBoard += "\n" + "   -----------------------------";
		displayBoard += "\n" + "1  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | "
				+ board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6];
		displayBoard += "\n" + "   -----------------------------";
		displayBoard += "\n" + "2  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | "
				+ board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6];
		displayBoard += "\n" + "   -----------------------------";
		displayBoard += "\n" + "3  " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | "
				+ board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6];
		displayBoard += "\n" + "   -----------------------------";
		displayBoard += "\n" + "4  " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | "
				+ board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6];
		displayBoard += "\n" + "   -----------------------------";
		displayBoard += "\n" + "5  " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | "
				+ board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6];
		// System.out.println(" |" + " |" + " |" + " |" + " |" + " | " + "| ");
		return displayBoard;
	}

	public boolean isValidColumn(int column) {
		boolean valid = false;
		if (column <= 6 || column >= 0) {
			valid = true;
		}
		else {
			valid = false;
		}
		return valid;
	}

	public boolean isColumnFull(int column) {
		boolean full = false;
		if (board[0][column] != ' ') {
			full = true;
		} else {
			full = false;
		}
		return full;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		boolean piecePlaced = false;
		for (int index = 0; index < board.length - 1; index++) {
			 if(board[index + 1][column] != ' '){
				board[index][column] = player.getPlayerPiece();
				piecePlaced = true;
			}
		}
		if(!piecePlaced) {
			board[5][column] = player.getPlayerPiece(); 
		}
	}

	public boolean didLastPieceConnect4() {
		boolean winner = false;
		if (connect4Across() == true || connect4Down() == true || connect4Diagonal() == true) {
			winner = true;
		}
		return winner;
	}

	public boolean connect4Across() {
		boolean connect4 = false;
		for (int currentRow = 0; currentRow < board.length; currentRow++) {
			for (int currentCol = 0; currentCol < board[currentRow].length - 3; currentCol++) {
				if ((board[currentRow][currentCol] == board[currentRow][currentCol + 1])
						&& (board[currentRow][currentCol + 1] == board[currentRow][currentCol + 2])
						&& (board[currentRow][currentCol + 2] == board[currentRow][currentCol + 3])
						&& (board[currentRow][currentCol] != ' ')) {
					connect4 = true;
				}
			}
		}
		return connect4;
	}

	public boolean connect4Down() {
		boolean connect4 = false;
		for (int currentRow = 0; currentRow < board.length - 3; currentRow++) {
			for (int currentCol = 0; currentCol < board[currentRow].length; currentCol++) {
				if ((board[currentRow][currentCol] == board[currentRow + 1][currentCol])
						&& (board[currentRow + 1][currentCol] == board[currentRow + 2][currentCol])
						&& (board[currentRow + 2][currentCol] == board[currentRow + 3][currentCol])
						&& (board[currentRow][currentCol] != ' ')) {
					connect4 = true;
				}
			}
		}
		return connect4;
	}

	public boolean connect4Diagonal() {
		boolean connect4 = false;
		for (int currentRow = 0; currentRow < board.length - 3; currentRow++) {
			for (int currentCol = 0; currentCol < board[currentRow].length - 3; currentCol++) {
				if ((board[currentRow][currentCol] == board[currentRow + 1][currentCol + 1])
						&& (board[currentRow + 1][currentCol + 1] == board[currentRow + 2][currentCol + 2])
						&& (board[currentRow + 2][currentCol + 2] == board[currentRow + 3][currentCol + 3])
						&& (board[currentRow][currentCol] != ' ')) {
					connect4 = true;
				}
			}
		}
		for (int currentRow = 0; currentRow < board.length - 3; currentRow++) {
			for (int currentCol = 6; currentCol >= 3; currentCol--) {
				if ((board[currentRow][currentCol] == board[currentRow + 1][currentCol - 1])
						&& (board[currentRow + 1][currentCol - 1] == board[currentRow + 2][currentCol - 2])
						&& (board[currentRow + 2][currentCol - 2] == board[currentRow + 3][currentCol - 3])
						&& (board[currentRow][currentCol] != ' ')) {
					connect4 = true;
				}
			}
		}
		return connect4;
	}

	public boolean isGridFull() {
		boolean isFull = false;
		int index = 0;
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				if (board[row][column] != ' ') {
					index++;
				}
			}
		}
		if (index == (ROWS * COLUMNS)) {
			isFull = true;
		} else {
			isFull = false;
		}
		return isFull;
	}
}
