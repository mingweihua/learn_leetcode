package leetcode;

public class Ques9 {

	public static void main(String[] args) {
		int x = Integer.MAX_VALUE;
		System.out.println(x);
	}

	public static boolean isPalindrome(int x) {
		int temp = x;
		if (x < 0) {
			return false;
		}
		long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
		return n == temp;
	}
}
