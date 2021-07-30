package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Ques171 {
	
	public static void main(String[] args) {

	}

	public int titleToNumber(String columnTitle) {
		int n = 1;
		int res = 0;
		for (int i = columnTitle.length()-1; i >=0 ; i--) {
			res += (columnTitle.charAt(i) - 'A' + 1) * n;
			n *= 26;
		}
		return res;
	}

}
