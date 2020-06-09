package application;

/**
 * <h2>A class to create and solve a Sudoku game.</h2>
 * <hr>
 * @author Josh Graham
 * @version 1.0
 */
public class Sudoku {
	// initializes the 9x9 sudoku grid
	private int[][] board = new int[9][9];
	
	/**
	 * Constructor for the Sudoku class.
	 */	
	public Sudoku() {
		this.board  = board;
	} // end constructor
	
	/**
	 * <h2>This method will print the current Sudoku board to the console.</h2>
	 * <p>
	 * The program does not naturally call this method but it can be used if 
	 * you would like to see the board in the console. This was specifically used
	 * for testing before the GUI was built.
	 * </p>
	 */
	public void printBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println("");
		}
	} // End printBoard method
	
	/**
	 * <h2>Mutator method to set a number at a specified location on the grid.</h2>
	 * 
	 * @param row	The row the number is going.
	 * @param col	The column the number is going.
	 * @param num	The number to be placed in the <code>[row][col]</code> position.
	 */
	public void setNumber(int row, int col, int num) {
		this.board[row][col] = num;
	} // End setNumber mutator
	
	/**
	 * <h2>Accessor method to get the number at a specified location on the grid.</h2>
	 * 
	 * <p>This is so that the SudokuController class can view the numbers on the grid.</p>
	 * @param row	The row of the number.
	 * @param col	The column of the number.
	 * @return The number found at the specified row and column.
	 */
	public int getNumber(int row, int col) {
		return this.board[row][col];
	} // End getNumber accessor
	
	/**
	 * <h2>This method checks if a number is valid in a specified position.</h2>
	 * 
	 * <p>A number is considered valid in sudoku if it appears only once within its column,
	 * row, and 3x3 sub-grid.</p>
	 * @param row The row of the number.
	 * @param col The column of the number.
	 * @param num A number between 1 and 9, to be played on the grid.
	 * @return True if valid, False otherwise.
	 */
	public boolean validPos(int row, int col, int num) {
		// Checking if the number already occurs within its row or column
		for(int i = 0; i < 9; i++) {
			if(this.board[row][i] == num || this.board[i][col] == num)
				return false;			
		}			
		int startRow;
		int startCol;		
		// Assigning starting positions for the row and column of the subgrid
		// that the number is a part of.
		if(row < 3)
			startRow = 0;
		else if(row < 6 && row > 2)
			startRow = 3;
		else
			startRow = 6;
		
		if(col < 3)
			startCol = 0;
		else if(col < 6 && col > 2)
			startCol = 3;
		else
			startCol = 6;
		// Checks to see if the number already occurs within the subgrid
		for(int i = startRow; i < startRow + 3; i++) {
			for(int j = startCol; j < startCol + 3; j++) {
				if(this.board[i][j] == num)
					return false;
			}
		}	
		// If the code reaches here, the number/position must be valid.
		return true;
	} // End validPos method
	
	/**
	 * <h2>This method will solve the current Sudoku board, as long as it is possible to solve.</h2>
	 * 
	 * <p>This is an implementation of the recursive backtracking algorithm.
	 * <a href="https://en.wikipedia.org/wiki/Backtracking">here</a> 
	 * is a link to the wikipedia page for the algorithm.</p>
	 * @param row The current row.
	 * @param col The current column.
	 * @return True or false, based on if the current path has won or lost the game.
	 */
	public boolean solveBoard(int row, int col) { 
		// If the column exceeds the board, it is reset and the row is increased.
		if(col == 9) {
			col = 0;
			row++;
		}
		// If the row has exceeded the board, the solution must have been found, return true
		if(row == 9)
			return true;
		// If the position is already filled in, just move on to the next position
		if(this.board[row][col] != 0)
			return this.solveBoard(row, col + 1);
		// Loops through 1-9, which are all the possible numbers to be played on the grid
		for(int i = 1; i < 10; i++) {
			if(this.validPos(row, col, i)) {
				this.board[row][col] = i; // The number is placed on the grid
				// Recursively call the function with the position from above filled
				if(this.solveBoard(row, col + 1))
					return true;
				
				this.board[row][col] = 0; // The number is removed from the grid, allowing others to be tried
			}
		}		
		return false; // There must be no way of winning on the current board
	} // end solveBoard method
} // End Sudoku class
