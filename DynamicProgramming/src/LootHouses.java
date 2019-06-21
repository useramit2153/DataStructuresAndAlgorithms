import java.util.Scanner;

public class LootHouses {
	
	public static int getMaxMoney(int arr[], int n){

		/*Your class should be named Solution. 
		*Don’t write main(). 
	 	*Don’t take input, it is passed as function argument.
	 	*Don’t print output.
	 	*Taking input and printing output is handled automatically.
		*/
		if(n == 0)
			return 0;
		if(n == 1)
			return arr[0];
		int[] storage = new int[arr.length];
		storage[0] = arr[0];
		storage[1] = Math.max(storage[0], arr[1]);
		for(int i = 2; i < arr.length; i ++)
			storage[i] = Math.max((arr[i] + storage[i - 2]), storage[i - 1]);
        return storage[arr.length - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = scan.nextInt();
		System.out.println(getMaxMoney(arr, n));
	}

}
