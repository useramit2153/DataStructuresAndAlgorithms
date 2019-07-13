import java.util.Scanner;

public class MaximumProfitOnApp {
	
	public static int maximumProfit(int budget[]) {
		QuickSortCode q = new QuickSortCode();
		q.quickSort(budget);
		int n = budget.length;
		int maxProfit = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++) {
			int profit = budget[i] * (n - i);
			if(profit > maxProfit)
				maxProfit = profit;
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] budget = new int[n];
		for(int i = 0; i < n; i ++)
			budget[i] = s.nextInt();
		System.out.println(maximumProfit(budget));
	}

}
