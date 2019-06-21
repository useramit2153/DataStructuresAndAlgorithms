import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WaysToMakeCoinChange {
	
	public static int countWaysToMakeChange(int[] denominations, int m, int n) {
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(m <= 0 && n >= 1)
			return 0;
		
		return countWaysToMakeChange(denominations, m - 1, n) + countWaysToMakeChange(denominations, m, n - denominations[m - 1]);
	}
	
	public static int countWaysToMakeChangeDP(int denominations[], int value) {
		int[][] storage = new int[denominations.length + 1][value + 1];
		storage[0][0] = 1;
		for(int i = 1; i <= denominations.length; i ++) {
			for(int j = 0; j <= value; j ++) {
				if(j < denominations[i - 1])
					storage[i][j] = storage[i - 1][j];
				else
					storage[i][j] = storage[i - 1][j] + storage[i][j - denominations[i - 1]];
			}
		}
		return storage[denominations.length][value];
	}
	
	public static int countWaysToMakeChange(int denominations[], int value){

		/*Your class should be named Solution.
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Don’t print output, instead return it.
		 */
		return countWaysToMakeChange(denominations, denominations.length, value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = scan.nextInt();
		int value = scan.nextInt();
		System.out.println(countWaysToMakeChangeDP(arr, value));
		System.out.println(countWaysToMakeChange(arr, value));
	}
	
}
