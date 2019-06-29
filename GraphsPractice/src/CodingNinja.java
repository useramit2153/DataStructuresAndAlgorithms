import java.util.Scanner;

public class CodingNinja {
	
	public static int findCodingNinjaHelper(String[] Graph, boolean[][] visited, char sv, int N, int M, int I, int J, int count, String s) {
		if(sv == 'A')
			return 1;
		
		int[] xDir = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] yDir = {-1, 0, 1, 1, 1, 0, -1, -1};
		
		visited[I][J] = true;
		int flag = 0;
		for(int i = 0; i < 8; i ++) {
			int xStep = I + xDir[i];
			int yStep = J + yDir[i];
			if((xStep >= 0 && xStep < N) && (yStep >= 0 && yStep < M)) {
				if((Graph[xStep].charAt(yStep) == s.charAt(count + 1)) && !visited[xStep][yStep]) {
					flag = findCodingNinjaHelper(Graph, visited, s.charAt(count + 1), N, M, xStep, yStep, count + 1, s);
					if(flag == 1)
						return 1;
				}
			}
		}
		visited[I][J] = false;
		return flag;
	}
	
	public static int findCodingNinja(String[] Graph, int N, int M) {
		String s = "CODINGNINJA";
		boolean[][] visited = new boolean[N][M];
		int flag = 0;
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j ++) {
				if(Graph[i].charAt(j) == 'C') {
					flag = findCodingNinjaHelper(Graph, visited, 'C', N, M, i, j, 0, s);
					if(flag == 1)
						return flag;
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		String[] Graph = new String[N];
		for(int i = 0; i < N; i ++)
			Graph[i] = s.next();
		s.close();
		System.out.println(findCodingNinja(Graph, N, M));
	}

}
