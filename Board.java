
interface Board{
	
	void startGame();

	void printBoard();
	
	int[][] showPossibleMoves();
	
	void makeMove(int row, int col);
	
	void resetDirection();
	
	boolean gameOver();
	
	boolean playerWin();
}
