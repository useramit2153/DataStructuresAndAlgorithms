
public class SContainTCheck {
	
	public static boolean checkSequence(String a, String b) {
		if(a.length() == 0 && b.length() != 0)
			return false;
		if(b.length() != 0) {
			boolean ans;
			if(a.charAt(0) == b.charAt(0))
				ans = checkSequence(a.substring(1), b.substring(1));
			else
				ans = checkSequence(a.substring(1), b);
			return ans;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkSequence("abcde", "aeb"));
	}

}
