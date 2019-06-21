import java.util.Scanner;

public class LongestIncreasingSubsequences {
	
	public static int lis(int arr[]) {

		/*Your class should be named Solution. 
		 *Don't write main().
		 *Don't take input, it is passed as function argument.
		 *Don't print output.
		 *Taking input and printing output is handled automatically.
		 */
		
		int[] storage = new int[arr.length];
		int max = 0;
		for(int i = 0; i < arr.length; i ++) {
			int prevLis = 0;
			for(int j = i - 1; j >= 0; j --) {
				if(arr[j] < arr[i]) {
					if(prevLis < storage[j])
						prevLis = storage[j];
				}
			}
			storage[i] = ++ prevLis;
			if(max < storage[i])
				max = storage[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = scan.nextInt();
		System.out.println(lis(arr));
	}

}
