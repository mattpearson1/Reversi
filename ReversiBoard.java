
public class ReversiBoard implements Board {
	
	private static int [][] board = new int [8][8];
	private static int [][] borderArray = new int [8][8];
	private static int [][] direction = new int [8][8];
	private static int [][] possibleMove = new int [8][8];
	private static int turnVariable, oppositeVariable;
	
	public void startGame() {
		System.out.println("Welcome to Reversi!"
				+ " Moves should be entered in \"[row] [column]\" format.\n");
		
		//X is 1, O is 2
		board [3][3] = 1;
		board [4][4] = 1;
		board [3][4] = 2;
		board [4][3] = 2;
		
		turnVariable = 1;
	}
	
	public void printBoard(){
		
		System.out.print(" ");
		for(int i = 1; i < 9; i++)
			System.out.print(" " + i);
		System.out.println();
		for(int j = 0; j < 8; j++){
			System.out.print(j + " ");
			for(int k = 0; k < 8; k++){
				if(board[j][k] == 1)
					System.out.print("X ");
				if(board[j][k] == 2)
					System.out.print("O ");
				if(borderArray[j][k] == 1)
					System.out.print("_ ");
				else if(board[j][k] == 0)
						System.out.print(". ");
			}
			System.out.println();
		}
	}
	
	public int[][] showPossibleMoves(){
		if(turnVariable == 1)
			oppositeVariable = 2;
		if(turnVariable == 2)
			oppositeVariable = 1;
		for(int i = 0; i < 8; i++){
			for(int h = 0; h < 8; h++){
				if((i == 0 || h == 0 || h == 7|| i == 7) && board[i][h] == 0){
					//top right corner
					if((i == 0 && h == 0) && board[i][h] == 0){
						if(board[i+1][h] == oppositeVariable){
							borderArray [i][h] = 1;
							direction[i][h] = 1; // direction turnVariable: target is below
						}
						if(board[i+1][h+1] == oppositeVariable){
							borderArray [i][h] = 1;
							direction[i][h] = 2; // direction 2: target is below to right
						}
						if(board[i][h+1] == oppositeVariable){
							borderArray [i][h] = 1;
							direction[i][h] = 3; // direction 3: target is to the right
						}	
					}
					//top row excluding the top right and left corners
					else if((i == 0 && h != 7) && board[i][h] == 0){
						if(board[i][h-1] == oppositeVariable){
							borderArray [i][h] = 1;
							direction[i][h] = 4; // direction 4: target is to left
						}
						if(board[i+1][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 5; // direction 5: target is to bottom left
						}
						if(board[i+1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 1;
						}
						if(board[i+1][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 2;
						}
						if(board[i][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 3;
						}
							
					}
					//top right corner
					else if ((i == 0 && h == 7) && board[i][h] == 0){
						if(board[i][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 4;
						}
						if(board[i+1][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 5;
						}
						if(board[i+1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 1;
						}
					}
					//right side
					else if ((h == 7 && i != 7) && board[i][h] == 0){
						if(board[i-1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 6; // direction 6: target is above
						}
						if(board[i-1][h-1] == oppositeVariable){
							borderArray [i][h] = 1;
							direction[i][h] = 7; // direction 7: target is above to left
						}
						if(board[i][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 4;
						}
						if(board[i+1][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 5;
						}
						if(board[i+1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 1;
						}
					}
					//bottom right corner
					else if((h == 7 && i == 7) && board[i][h] == 0){
						if(board[i][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 4;
						}
						if(board[i-1][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 7;
						}
						if(board[i-1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 6;
						}
					}
					//bottom side
					else if((i == 7 && h != 0) && board[i][h] == 0){
						if(board[i][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 4;
						}	
						if(board[i-1][h-1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 7;
						}
						if(board[i-1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 6;
						}	
						if(board[i-1][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 8; // direction 8: target is above to right
						}
						if(board[i][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 3;
						}
					}
					//bottom left corner
					else if((i == 7 && h == 0) && board[i][h] == 0){
						if(board[i-1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 6;
						}
							if(board[i-1][h+1] == oppositeVariable){
								borderArray [i][h] = 1; 
								direction[i][h] = 8;
							}
							if(board[i][h+1] == oppositeVariable){
								borderArray [i][h] = 1; 
								direction[i][h] = 3;
							}
					}
					//left side
					else if((h == 0) && board[i][h] == 0){
						if(board[i-1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 6;
						}
						if(board[i-1][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 8;
						}
						if(board[i][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 3;
						}
						if(board[i+1][h+1] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 2;
						}
						if(board[i+1][h] == oppositeVariable){
							borderArray [i][h] = 1; 
							direction[i][h] = 1;
						}	
					}
				}
				//middle pieces
				else{
					if((board[i-1][h-1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 7;
					}
					if((board[i-1][h] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 6;
					}
					if((board[i-1][h+1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 8;
					}
					if((board[i][h-1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 4;
					}
					if((board[i][h+1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 3;
					}
					if((board[i+1][h-1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 5;
					}
					if((board[i+1][h] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 1;
					}
					if((board[i+1][h+1] == oppositeVariable) && board[i][h] == 0){
						borderArray [i][h] = 1; 
						direction[i][h] = 2;
					}
				}
			}
		}
		for(int a = 0; a < 8; a++){
			for(int b = 0; b < 8; b++){
				switch(direction[a][b]){
				case 1: //below
					for(int n = a; n < 8; n++){
						if(board[n][b] == turnVariable)
							possibleMove[a][b] = 1;
						}
					break;
				case 2: //below right
					for(int n = a, m = b; n < 8 && m < 8; n++, m++){
						if(board[n][m] == turnVariable)
							possibleMove[a][b] = 1;
					}
					break;
				case 3: //right
					for(int n = b; n < 8; n++){
						if(board[a][n] == turnVariable)
							possibleMove[a][b] = 1;
						}
					break;
				case 4: //left
					for(int n = b; n > 0; n--){
						if(board[a][n] == turnVariable)
							possibleMove[a][b] = 1;
						}
					break;
				case 5: //below left
					for(int n = a, m = b; n < 8 && m > 0; n++, m--){
						if(board[n][m] == turnVariable)
							possibleMove[a][b] = 1;
					}
					break;
				case 6: //above
					for(int n = a; n > 0; n--){
						if(board[n][b] == turnVariable)
							possibleMove[a][b] = 1;
						}
					break;
				case 7: //above left
					for(int n = a, m = b; n > 0 && m > 0; n--, m--){
						if(board[n][m] == turnVariable)
							possibleMove[a][b] = 1;
					}
					break;
				case 8: //above right
					for(int n = a, m = b; n > 0 && m < 8; n--, m++){
						if(board[n][m] == turnVariable)
							possibleMove[a][b] = 1;
					}
					break;
				}
			}
		}
		return possibleMove;
	}

	public void makeMove(int row, int col) {
		if(possibleMove[row][col] == 0){
			System.out.println("That was not a valid move. Try again. \n");
		}
		else{
			switch(direction[row][col]){
			case 1: //below
				for(int n = row; n < 8; n++){
					while(board[n][col] != turnVariable)
						board[n][col] = turnVariable;
				}
				break;
			case 2: //below right
				for(int n = row, m = col; n < 8 && m < 8; n++, m++){
					while(board[n][m] != turnVariable)
						board[n][m] = turnVariable;
				}
				break;
			case 3: //right
				for(int n = col; n < 8; n++){
					while(board[row][n] != turnVariable)
						board[row][n] = turnVariable;
					}
				break;
			case 4: //left
				for(int n = col; n > 0; n--){
					while(board[row][n] != turnVariable)
						board[row][n] = turnVariable;
					}
				break;
			case 5: //below left
				for(int n = row, m = col; n < 8 && m > 0; n++, m--){
					while(board[n][m] != turnVariable)
						board[n][m] = turnVariable;
				}
				break;
			case 6: //above
				for(int n = row; n > 0; n--){
					while(board[n][col] != turnVariable)
						board[n][col] = turnVariable;
					}
				break;
			case 7: //above left
				for(int n = row, m = col; n > 0 && m > 0; n--, m--){
					while(board[n][m] != turnVariable)
						board[n][m] = turnVariable;
				}
				break;
			case 8: //above right
				for(int n = row, m = col; n > 0 && m < 8; n--, m++){
					while(board[n][m] != turnVariable)
						board[n][m] = turnVariable;
				}
				break;
			}
			turnVariable = oppositeVariable;
		}
	}

	public void resetDirection() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++)
				direction[i][j] = 0;
		}
	}


	public boolean gameOver(){

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public boolean playerWin(){
		int playerScore = 0, computerScore = 0;
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(board[i][j] == 1)
						playerScore++;
					if(board[i][j] == 2)
						computerScore++;
				}
			}
			if(playerScore > computerScore)
				return true;
			else
				return false;
	}
	
}
