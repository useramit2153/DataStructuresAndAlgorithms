import java.util.Scanner;

public class MatrixChainMultiplication {

	public static int minCost(int[] arr, int s, int e) {
		if(s ==  e - 1 || s == e)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int i = s + 1; i < e; i ++) {
			int v = minCost(arr, s, i) + minCost(arr, i, e) + (arr[s] * arr[i] * arr[e]);
			if(min > v)
				min = v;
		}
		return min;
	}
	
	public static int minCostDP(int[] arr) {
		int[][] storage = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < arr.length - i; j ++) {
				if(j == j + i || j == (j + i) - 1)
					storage[j][j + i] = 0;
				else {
					int x = j;
					int y = j + i;
					int min = Integer.MAX_VALUE;
					for(int k = x + 1; k < y; k ++) {
						int v = storage[x][k] + storage[k][y] + (arr[x] * arr[k] * arr[y]);
						if(min > v)
							min = v;
					}
					storage[x][y] = min;
				}
			}
		}
		return storage[0][arr.length - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n + 1];
		for(int i = 0; i <= n; i ++)
			arr[i] = scan.nextInt();
		System.out.println(minCostDP(arr));
		System.out.println(minCost(arr, 0, n));
	}

}
