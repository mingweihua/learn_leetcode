package leetcode;

public class Ques8 {

	public static void main(String[] args) {
		System.out.println(myAtoi("   -42"));
	}

	public static int myAtoi(String str) {
		str = str.trim();
		if ("".equals(str)) {
			return 0;
		}
		if ((str.charAt(0) < '0' || str.charAt(0) > '9') && str.charAt(0) != '-' && str.charAt(0) != '+') {
			return 0;
		}
		int first = 1;
		long num = 0;
		if (str.charAt(0) == '-') {
			first = -1;
		}
		if (!(str.charAt(0) < '0' || str.charAt(0) > '9')) {
			num = num * 10 + (str.charAt(0)-'0');
		}
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				break;
			}
			num = num * 10 + first * (str.charAt(i) - '0');
			if (num > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (num < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		return (int) num;
	}

}
