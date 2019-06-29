import java.util.Scanner;

public class ConnectingDots {
	
	public static int connectingDotsHelper(String[] board, boolean[][] visited, int dir, int I, int J, int N, int M) {
		visited[I][J] = true;
		int[] xDir = {0, 1, 0, -1};
		int[] yDir = {1, 0, -1, 0};
		int flag = 0;
		for(int i = 0; i < 4; i ++) {
			if(i != ((dir + 2) % 4)) {
				// valid directions
				int xStep = I + xDir[i];
				int yStep = J + yDir[i];
				if((xStep >= 0 && xStep < N) && (yStep >= 0 && yStep < M)) {
					// valid region
					if(board[I].charAt(J) == board[xStep].charAt(yStep)) {
						// valid path
						if(visited[xStep][yStep])
							return 1;
						else
							flag = connectingDotsHelper(board, visited, i, xStep, yStep, N, M);
						if(flag == 1)
							return 1;
					}
				}
			}
		}
		return flag;
	}
	
	public static int connectingDots(String[] board, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		int flag = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(!visited[i][j]) {
					flag = connectingDotsHelper(board, visited, 0, i, j, n, m);
					if(flag == 1)
						return 1;
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		String[] board = new String[N];
		for(int i = 0; i < N; i ++)
			board[i] = s.next();
		s.close();
		System.out.println(connectingDots(board, N, M));
	}

}
