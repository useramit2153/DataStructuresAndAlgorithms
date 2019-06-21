import java.util.Scanner;

public class MaxSquareMatrixWithAllZeros {
	
	public static int findMaxSquareWithAllZeros(int[][] input){

		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		
		int n = input.length;
		int m = input[0].length;
		
		int[][] storage = new int[n][m];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i ++) {
			if(input[i][0] == 0)
				storage[i][0] = 1;
			else
				storage[i][0] = 0;
			if(max < storage[i][0])
				max = storage[i][0];
		}
		
		for(int j = 0; j < m; j ++) {
			if(input[0][j] == 0)
				storage[0][j] = 1;
			else
				storage[0][j] = 0;
			if(max < storage[0][j])
				max = storage[0][j];
		}
		
		for(int i = 1; i < n; i ++) {
			for(int j = 1; j < m; j ++) {
				if(input[i][j] == 0)
					storage[i][j] = Math.min(storage[i - 1][j - 1], Math.min(storage[i][j - 1], storage[i - 1][j])) + 1;
				else
					storage[i][j] = 0;
				if(max < storage[i][j])
					max = storage[i][j];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] input = new int[n][m];
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++)
				input[i][j] = scan.nextInt();
		}
		System.out.println(findMaxSquareWithAllZeros(input));
	}

}
