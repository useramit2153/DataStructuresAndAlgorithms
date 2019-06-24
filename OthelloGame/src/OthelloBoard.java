
public class OthelloBoard {
	private int board[][];
	final static int p1color = 1;
	final static int p2color = 2;
    private boolean entry = false;
    private int boardSize = 8;
    
	public OthelloBoard() {
		board = new int[8][8];
		
		board[0][3] = p1color;
		board[1][3] = p1color;
		board[2][2] = p1color;
		board[2][3] = p1color;
		board[2][4] = p1color;
		board[3][1] = p2color;
		board[3][2] = p2color;
		board[3][3] = p1color;
		board[3][4] = p2color;
		board[4][2] = p1color;
		board[4][3] = p1color;
		board[4][4] = p1color;
		board[4][5] = p2color;
		board[4][6] = p1color;
		board[4][7] = p1color;
		board[5][1] = p1color;
		board[5][3] = p2color;
		board[5][6] = p2color;
		board[6][7] = p2color;
		
		board[3][3] = p1color;
		board[3][4] = p2color;
		board[4][3] = p2color;
		board[4][4] = p1color;
	}

	public void print() {
		System.out.println();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean move(int color, int x, int y){
		// Complete this function
		/* Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		if(board[x][y] != 0 || x < 0 || x > boardSize || y < 0 || y > boardSize)
			return false;
        int[] xDir = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] yDir = {-1, 0, 1, 1, 1, 0, -1, -1};
		for(int i = 0; i < xDir.length; i ++) {
			if((x + xDir[i] >= 0 && x + xDir[i] < boardSize) && (y + yDir[i] >= 0 && y + yDir[i] < boardSize)) {
				// within matrix
				int a = x + xDir[i];
				int b = y + yDir[i];
				if(color == p1color) {
					// Player 1
					if(p2color == board[a][b]) {
						// opposite color
						while(board[a][b] == p2color) {
							a = a + xDir[i];
							b = b + yDir[i];
							if((a < 0 || a >= boardSize) || (b < 0 || b >= boardSize)) {
								break;
							}
						}
						if((a < 0 || a >= boardSize) || (b < 0 || b >= boardSize)) {
							continue;
						}
						if(board[a][b] == p1color) {
							// entry
							board[x][y] = p1color;
							a = a - xDir[i];
							b = b - yDir[i];
							while(board[a][b] == p2color) {
								board[a][b] = p1color;
								a = a - xDir[i];
								b = b - yDir[i];
//                                if((a < 0 || a >= boardSize) || (b < 0 || b >= boardSize)) {
//                                    a = a + xDir[i];
//                                    b = b +xDir[i];
//                                    break;
//                                }
							}
							entry = true;
						}
					}
				} else {
					// Player 2
					if(p1color == board[a][b]) {
						// opposite color
						while(board[a][b] == p1color) {
							a = a + xDir[i];
							b = b + yDir[i];
							if((a < 0 || a >= boardSize) || (b < 0 || b >= boardSize)) {
								break;
							}
						}
						if((a < 0 || a >= boardSize) || (b < 0 || b >= boardSize)) {
							continue;
						}
						if(board[a][b] == p2color) {
							// entry
							board[x][y] = p2color;
							a = a - xDir[i];
							b = b - yDir[i];
							while(board[a][b] == p1color) {
								board[a][b] = p2color;
								a = a - xDir[i];
								b = b - yDir[i];
//                                if((a < 0 && a >= boardSize) && (b < 0 && b >= boardSize)) {
//                                    a = a + xDir[i];
//                                    b = b +xDir[i];
//                                    break;
//                                }
							}
							entry = true;
						}
					}
				}
			}
		}
		
		if(entry) {
			entry = false;
			return true;
		}else
		    return false;
	}
	
}
