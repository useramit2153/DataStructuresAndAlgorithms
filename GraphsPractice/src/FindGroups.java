import java.util.Scanner;

public class FindGroups {
	
	public static void findGroupsHelper(int[][] edges, int sv, boolean[] visited) {
		visited[sv] = true;
		for(int i = 0; i < edges.length; i ++) {
			if(edges[sv][i] == 1 && !visited[i])
				findGroupsHelper(edges, i, visited);
		}
	}
	
	public static int findGroups(int n, int m, int[] U, int[] V) {
		int[][] edges = new int[n + 1][n + 1];
		for(int i = 0; i < m; i ++) {
			edges[U[i]][V[i]] = 1;
			edges[V[i]][U[i]] = 1;
		}
		boolean[] visited = new boolean[edges.length];
		int count = 0;
		for(int i = 1; i <= n; i ++) {
			if(!visited[i]) {
				findGroupsHelper(edges, i, visited);
				count ++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] U = new int[m];
		int[] V = new int[m];
		for(int i = 0; i < m; i ++){
			U[i] = s.nextInt();
			V[i] = s.nextInt();
		}
		System.out.println(findGroups(n, m, U, V));
	}
	
}
