
public class Board {
	private char[][] board;
	private char p1color, p2color;
	private int boardSize = 8;
	private int count;
	private int p1ColorCount;
	private int p2ColorCount;
	private boolean entry = false;
	public static final int PLAYER_1_WINS = 1;
	public static final int PLAYER_2_WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALID = 5;
	
	public Board(char p1Color, char p2Color) {
		board = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i ++) {
			for(int j = 0; j < boardSize; j ++) {
				board[i][j] = ' ';
			}
		}
		board[3][3] = 'w';
		board[3][4] = 'b';
		board[4][3] = 'b';
		board[4][4] = 'w';
		this.p1color = p1Color;
		this.p2color = p2Color;
		this.count = 0;
		this.p1ColorCount = 0;
		this.p2ColorCount = 0;
	}

	public int move(int x, int y, char color) {
		
		if(board[x][y] != ' ' || x < 0 || x > boardSize || y < 0 || y > boardSize)
			return INVALID;
		
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
							}
							entry = true;
							count ++;
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
							}
							entry = true;
							count ++;
						}
					}
				}
			}
		}
		
		if(count == (boardSize * boardSize) - 4) {
			// board full and decides to winner or draw
			for(int i = 0; i < boardSize; i ++) {
				for(int j = 0; j < boardSize; j ++) {
					if(board[i][j] == p1color)
						p1ColorCount ++;
					else
						p2ColorCount ++;
				}
			}
			
			if(p1ColorCount == p2ColorCount)
				return DRAW;
			return (p1ColorCount > p2ColorCount) ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		// invalid move
		if(!entry)
			return INVALID;
		entry = false;
		
		// incomplete
		return INCOMPLETE;
		
	}

	public void print() {
		System.out.print("   ");
		for(int i = 0; i < boardSize; i ++)
			System.out.print("|" + i + "|");
		System.out.println();
		
		for(int i = 0; i < boardSize; i ++) {
			System.out.print("|" + i + "|");
			for(int j = 0; j < boardSize; j ++) {
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println();
		}
	}
	
}
