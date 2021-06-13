package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques7 {

	public static void main(String[] args) {
		int num = 123;
		System.out.println(num);
		System.out.println(reverse2(num));
		
		long x = Integer.MAX_VALUE + 1L;
		System.out.println(x);
		int y = (int) x;
		System.out.println(y);
		System.out.println(x==y);
	}

	public static int reverse(int x) {
		List<Integer> numList = new ArrayList<Integer>();
		while (x != 0) {
			numList.add((x % 10));
			x = x / 10;
		}
		double reverse = 0;
		for (int i = 0; i < numList.size(); i++) {
			System.out.println(numList.get(i));
			reverse =  reverse + numList.get(i) * Math.pow(10, numList.size()-1-i);
		}
		if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) reverse;
	}
	
	public static int reverse2(int x) {
		int temp = 0;
		if (x < 0) {
			temp = Integer.toString(x).length()-1;
		} else {
			temp = Integer.toString(x).length();
		}
		double reverse = 0;
		int i = 0;
		while (x != 0) {
			reverse = reverse + (x % 10) * Math.pow(10, temp-1-i);
			x = x / 10;
			i++;
		}
		if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) reverse;
	}
	
	public static int reverse3(int x) {
		String s = Integer.toString(x);
		String reverse = "";
		for (int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == '-') {
				reverse = '-' + reverse;
				continue;
			}
			reverse += s.charAt(i);
		}
		double num = Double.parseDouble(reverse);
		if (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) num;
	}
	
	public static int reverse4(int x) {
		long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
	}

}
