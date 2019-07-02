import java.util.Scanner;

public class PrimsAlgo {
	
	public static int findMin(int[] weight, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int v = 0;
		for(int i = 0; i < weight.length; i ++) {
			if(!visited[i] && min > weight[i]) {
				min = weight[i];
				v = i;
			}
		}
		return v;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] Graph = new int[V][V];
		int[] parents = new int[V];
		int[] weight = new int[V];
		boolean[] visited = new boolean[V];
		boolean[] unvisited = new boolean[V];
		
		// take input
		for(int i = 0; i < E; i ++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			int w = s.nextInt();
			Graph[sv][ev] = w;
			Graph[ev][sv] = w;
		}
		s.close();
		
		// initialize
		parents[0] = -1;
		weight[0] = 0;
		unvisited[0] = true;
		for(int i = 1; i < V; i ++) {
			weight[i] = Integer.MAX_VALUE;
			unvisited[i] = true;
		}
		
		// processing
		for(int i = 0; i < (V - 1); i ++) {
			int v = findMin(weight, visited);
			visited[v] = true;
			unvisited[v] = false;
			for(int j = 0; j < V; j ++) {
				if(Graph[v][j] != 0 && !visited[j]) {
					// Adjacent Vertices
					if(Graph[v][j] < weight[j]) {
						weight[j] = Graph[v][j];
						parents[j] = v;
					}
				}
			}
		}
		
		// output
		for(int i = 1; i < V; i ++) {
			int sv = parents[i];
			int ev = i;
			System.out.println(Math.min(sv, ev) + " " + Math.max(sv, ev) + " " + weight[i]);
		}
		
	}

}
