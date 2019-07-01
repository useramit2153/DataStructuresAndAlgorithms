import java.util.Scanner;

public class LargestPiece {
	
	public static int largestPieceHelper(String[] cake, boolean[][] visited, int count, int I, int J, int N) {
		visited[I][J] = true;
		int[] xDir = {0, 1, 0, -1};
		int[] yDir = {1, 0, -1, 0};
		
		int c = count;
		for(int i = 0; i < xDir.length; i ++) {
			int xStep = I + xDir[i];
			int yStep = J + yDir[i];
			if((xStep >= 0 && xStep < N) && (yStep >= 0 && yStep < N)) {
				// valid region
				if(cake[xStep].charAt(yStep) == '1') {
					// valid step
					if(!visited[xStep][yStep]) {
						// not visited
						c = largestPieceHelper(cake, visited, c + 1, xStep, yStep, N);
					}
				}
			}
		}
		
		return c;
	}
	
	public static int largestPiece(int n, String cake[]) {
		boolean[][] visited = new boolean[n][n];
		int c = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				if(cake[i].charAt(j) == '1' && !visited[i][j]) {
					int r = largestPieceHelper(cake, visited, 1, i, j, n);
					if(c < r)
						c = r;
				}
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		String[] cake = new String[n];
		for(int i = 0; i < n; i ++)
			cake[i] = s.next();
		
		s.close();
		
		System.out.println(largestPiece(n, cake));
	}

}
