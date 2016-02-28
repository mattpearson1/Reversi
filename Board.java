
interface Board{
	
	void startGame();
	

	void printBoard();
	
	void showPossibleMoves();
	
	void makeMove(int row, int col);
	
	void resetDirection();
	
	boolean gameOver();
	
	boolean playerWin();
}
