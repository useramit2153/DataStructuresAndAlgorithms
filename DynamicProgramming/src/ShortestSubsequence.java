import java.util.Scanner;

public class ShortestSubsequence {
	
	public static int shortestSubsequenceDP(String S, String V) {
		int m = S.length();
		int n = V.length();
		int[][] storage = new int[m + 1][n + 1];
		for(int i = 1; i <= m; i ++)
			storage[i][0] = 1;
		for(int j = 0; j <= n; j ++)
			storage[0][j] = Integer.MAX_VALUE;
		for(int i = 1; i <= m; i ++) {
			char ch = S.charAt(i - 1);
			for(int j = 1; j <= n; j ++) {
				// Searching
				int k;
				for(k = j - 1; k >= 0; k --) {
					if(V.charAt(k) == ch)
						break;
				}
				// Not Found
				if(k == -1)
					storage[i][j] = 1;
				else {
					int x = storage[i - 1][j];
					int y = storage[i - 1][k];
					if(y != Integer.MAX_VALUE)
						y ++;
					storage[i][j] = Math.min(x, y);
				}
			}
		}
		return storage[m][n];
	}
	
	public static int solve(String S,String V){

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		
		if(S.length() == 0 && V.length() == 0) {
			System.out.println("hello");
			return 1;
		}
		else if(S.length() == 0) {
			//System.out.println("hello");
			return Integer.MAX_VALUE;
		}
		else if(V.length() == 0) {
			return 1;
		}
		
		//System.out.println(S + " " + V);
		
		int x = solve(S.substring(1), V);
		int y;
		if(V.indexOf(S.charAt(0)) == -1)
			return 1;
		else
			y = solve(S.substring(1), V.substring(V.indexOf(S.charAt(0)) + 1));
		if(y != Integer.MAX_VALUE)
			y = y + 1;
		return Math.min(x, y);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		String t = scan.next();
		System.out.println(shortestSubsequenceDP(s, t));
		System.out.println(solve(s, t));
		//System.out.println(t.indexOf(s.charAt(0)));
	}

}
