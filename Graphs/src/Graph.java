import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

	public static void dfsPrintHelper(int[][] edges, int sv, boolean[] visited) {
		System.out.println(sv);
		visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n; i ++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				dfsPrintHelper(edges, i, visited);
			}
		}
	}
	
	public static void dfsPrint(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i < edges.length; i ++) {
			if(!visited[i])
				dfsPrintHelper(edges, i, visited);
		}
	}
	
	public static void bfsPrintHelper(int[][] edges, int sv, boolean[] visited, Queue<Integer> q) {
		System.out.println(sv);
		for(int i = 0; i < edges.length; i ++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				q.add(i);
				visited[i] = true;
			}
		}
		q.remove();
		if(!q.isEmpty())
			bfsPrintHelper(edges, q.element(), visited, q);
	}
	
	public static void bfsPrint(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		Queue<Integer> queue = new LinkedList<Integer>();
//		for(int i = 0; i < edges.length; i ++) {
//			if(!visited[i]) {
				queue.add(0);
				visited[0] = true;
				bfsPrintHelper(edges, queue.element(), visited, queue);
//			}
//		}
	}
	
	public static boolean hasPath(int[][] edges, int sv, int ev) {
		boolean[] visited = new boolean[edges.length];
		boolean flag = hasPathHelper(edges, sv, ev, visited);
		return flag;
	}
	
	private static boolean hasPathHelper(int[][] edges, int sv, int ev, boolean[] visited) {
		if(sv == ev)
			return true;
		visited[sv] = true;
		int n = edges.length;
		boolean flag = false;
		for(int i = 0; i < n; i ++) {
			if(edges[sv][i] == 1 && !visited[i] && !flag) {
				flag = hasPathHelper(edges, i, ev, visited);
			}
		}
		return flag;
	}

	public static void getPathDfs(int[][] edges, int sv, int ev) {
		boolean[] visited = new boolean[edges.length];
		//ArrayList<Integer> list = new ArrayList<Integer>();
		getPathHelperDfs(edges, sv, ev, visited);
	}
	
	private static boolean getPathHelperDfs(int[][] edges, int sv, int ev, boolean[] visited) {
		if(sv == ev) {
			System.out.print(sv + " ");
			return true;
		}
		visited[sv] = true;
		int n = edges.length;
		boolean flag = false;
		for(int i = 0; i < n; i ++) {
			if(edges[sv][i] == 1 && !visited[i] && !flag) {
				flag = getPathHelperDfs(edges, i, ev, visited);
				if(flag)
					System.out.print(sv + " ");
			}
		}
		return flag;
	}

	public static boolean getPathHelperBfs(int[][] edges, int sv, int ev, boolean[] visited, Queue<Integer> q, int[] arr) {
		
		boolean flag = false;
		for(int i = 0; i < edges.length; i ++) {
			if(edges[sv][i] == 1 && !visited[i] && !flag) {
				q.add(i);
				arr[i] = sv;
				visited[i] = true;
				if(i == ev)
					return true;
			}
		}
		q.remove();
		if(!q.isEmpty() && !flag)
			flag = getPathHelperBfs(edges, q.element(), ev, visited, q, arr);
		return flag;
	}
	
	public static void getPathBfs(int[][] edges, int sv, int ev) {
		boolean[] visited = new boolean[edges.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sv);
		visited[sv] = true;
		int[] arr = new int[edges.length];
		arr[sv] = -1;
		boolean flag = getPathHelperBfs(edges, queue.element(), ev, visited, queue, arr);
		if(flag) {
			System.out.print(ev + " ");
			int i = ev;
			while(arr[i] != -1) {
				System.out.print(arr[i] + " ");
				i = arr[i];
			}
//			for(int i = 0; i < arr.length; i ++)
//				System.out.print(arr[i] + " ");
		}
	}
	
	public static void isConnectedHelper(int[][] edges, int sv, boolean[] visited) {
		visited[sv] = true;
		for(int i = 0; i < edges.length; i ++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				isConnectedHelper(edges, i, visited);
			}
		}
	}
	
	public static boolean isConnected(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		isConnectedHelper(edges, 0, visited);
		for(int i = 0; i < visited.length; i ++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
	
	public static void allConnectedComponentsHelper(int[][] edges, int sv, boolean[] visited, ArrayList<Integer> list) {
		visited[sv] = true;
		list.add(sv);
		for(int i = 0; i < edges.length; i ++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				allConnectedComponentsHelper(edges, i, visited, list);
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> allConnectedComponents(int[][] edges) {
		ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i < edges.length; i ++) {
			if(!visited[i]) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				allConnectedComponentsHelper(edges, i, visited, list);
				list.sort(null);
				components.add(list);
			}
		}
		return components;
	}

	public static void main(String[] args) {
		int n;
		int e;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int[][] edges = new int[n][n];
		for(int i = 0; i < e; i ++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		//dfsPrint(edges);
		//bfsPrint(edges);
//		int sv = s.nextInt();
//		int ev = s.nextInt();
		//System.out.println(hasPath(edges, sv, ev));
		//getPathDfs(edges, sv, ev);
//		getPathBfs(edges, sv, ev);
//		System.out.println(isConnected(edges));
		ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
		components = allConnectedComponents(edges);
		for(int i = 0; i < components.size(); i ++) {
			for(int j = 0; j < components.get(i).size(); j ++)
				System.out.print(components.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
