
public class AllPossibleWays {
	
	public static int allWays(int x, int rn, int p) {
		if(rn < 0)
			return 0;
		if(rn == 0)
			return 1;
		int ans = 0;
		for(int i = x + 1; i <= (int)Math.sqrt(rn); i ++) {
			int smallAns = allWays(i, (rn - (int)Math.pow(i, p)), p);
			if(smallAns != 0)
				ans = ans + smallAns;
		}
		return ans;
	}
	
	public static int allWays(int x, int n) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		return allWays(0, x, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allWays(26, 2));
		
	}

}
