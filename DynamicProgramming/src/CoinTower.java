import java.util.Scanner;

public class CoinTower {
	
	public static int cointower(int n, int x, int y) {
		if(n == 1 || n == x || n == y)
			return 1;
		
		int a, b = 0, c = 0;
		a = cointower(n - 1, x, y);
		if(n >= x)
			b = cointower(n - x, x, y);
		if(n >= y)
			c = cointower(n - y, x, y);
		
		return Math.max((a ^ 1), Math.max((b ^ 1), (c ^ 1)));
	}
	
	public static String cointowerDP(int n, int x, int y) {
		int[] storage = new int[n + 1];
		storage[1] = 1;
		storage[x] = 1;
		storage[y] = 1;
		for(int i = 1; i <= n; i ++) {
			int a = 0, b = 0, c = 0;
			if(i - 1 > 0)
				a = storage[ i - 1 ];
			if(i - x > 0)
				b = storage[ i - x ];
			if(i - y > 0)
				c = storage[i - y ];
			storage[i] = Math.max((a ^ 1), Math.max((b ^ 1), (c ^ 1)));
		}
		if(storage[n] != 0)
			return "Beerus";
		else
			return "Whis";
	}
	
	public static String solve(int n,int x,int y){	
		// Write your code here .
		int a = cointower(n, x, y);
		if(a == 0)
			return "Whis";
		else
			return "Beerus";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println(cointowerDP(n, x, y));
		System.out.println(solve(n, x, y));
	}

}
