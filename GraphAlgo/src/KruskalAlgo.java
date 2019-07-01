import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KruskalAlgo {
	
	private static boolean checkCycle(int[] parents, int sv, int ev) {
		// search parents of starting vertex
		int i = sv;
		while(parents[i] != i)
			i = parents[i];
		
		// search parents of ending vertex
		int j = ev;
		while(parents[j] != j)
			j = parents[j];
		
		// set parents
		if(i != j)
			parents[i] = j;
		
		return (i == j) ? true : false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		ArrayList<Edge> edges = new ArrayList<Edge>(E);
		ArrayList<Edge> spanEdges = new ArrayList<Edge>(V - 1);
		int[] parents = new int[V];
		for(int i = 0; i < V; i ++)
			parents[i] = i;
		
		// take input
		for(int i = 0; i < E; i ++)
			edges.add(takeInput(s));
		s.close();
		
		// sorting
		Collections.sort(edges, new SortObject());
		
//		for(int i = 0; i < E; i ++)
//			System.out.println(edges.get(i).getSV() + " " + edges.get(i).getEV() + " " + edges.get(i).getCost());
		
		int c = 0;
		for(int i = 0; i < E; i ++){
			if(c == (V - 1))
				break;
			if(!checkCycle(parents, edges.get(i).getSV(), edges.get(i).getEV())) {
				// Attach Edge
				Edge e = new Edge(Math.min(edges.get(i).getSV(), edges.get(i).getEV()), Math.max(edges.get(i).getSV(), edges.get(i).getEV()), edges.get(i).getCost());
				spanEdges.add(e);
				c ++;
			}
		}
		
		// Output
		for(int i = 0; i < spanEdges.size(); i ++)
			System.out.println(spanEdges.get(i).getSV() + " " + spanEdges.get(i).getEV() + " " + spanEdges.get(i).getCost());
		
	}

	public static Edge takeInput(Scanner s) {
		int sv = s.nextInt();
		int ev = s.nextInt();
		int w = s.nextInt();
		Edge e = new Edge(sv, ev, w);
		return e;
	}

}
