import java.util.Scanner;

public class Cycle3 {
	
	public static int countCycle3Helper(int sv, int[][] Graph) {
		int i = sv;
		int c = 0;
		for(int j = 1; j < Graph.length; j ++) {
			if(Graph[i][j] == 1) {
				for(int k = 1; k < Graph.length; k ++) {
					if(Graph[j][k] == 1 && k != i) {
						if(Graph[k][i] == 1)
							c ++;
					}
				}
			}
		}
		return c;
	}
	
	public static int countCycle3(int n, int m, int[] U, int[] V) {
		// creating graph
		int[][] Graph = new int[n + 1][n + 1];
		for(int i = 0; i < m; i ++) {
			Graph[U[i]][V[i]] = 1;
			Graph[V[i]][U[i]] = 1;
		}
		
		// creating visited array
		boolean[] visited = new boolean[n + 1];
		
		// visit the graph using DFS and count
		int c = 0;
		for(int i = 1; i <= n; i ++)
			c += countCycle3Helper(i, Graph);
		return c / 6;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] U = new int[m];
		int[] V = new int[m];
		for(int i = 0; i < m; i ++)
			U[i] = s.nextInt();
		for(int i = 0; i < m; i ++)
			V[i] = s.nextInt();
		s.close();
		
		System.out.println(countCycle3(n, m, U, V));
	}

}
