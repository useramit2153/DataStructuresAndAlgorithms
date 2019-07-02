import java.util.Scanner;

public class DijkstrasAlgo {
	
	public static int findMin(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int v = 0;
		for(int i = 0; i < distance.length; i ++) {
			if(!visited[i] && min > distance[i]) {
				min = distance[i];
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
		int[] distance = new int[V];
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
		distance[0] = 0;
		unvisited[0] = true;
		for(int i = 1; i < V; i ++) {
			distance[i] = Integer.MAX_VALUE;
			unvisited[i] = true;
		}
		
		// processing
		for(int i = 0; i < (V - 1); i ++) {
			int v = findMin(distance, visited);
			visited[v] = true;
			unvisited[v] = false;
			for(int j = 0; j < V; j ++) {
				if(Graph[v][j] != 0 && !visited[j]) {
					// Adjacent Vertices
					if((distance[v] + Graph[v][j]) < distance[j])
						distance[j] = distance[v] + Graph[v][j];
				}
			}
		}
		
		// output
		for(int i = 0; i < V; i ++)
			System.out.println(i + " " + distance[i]);

	}

}
