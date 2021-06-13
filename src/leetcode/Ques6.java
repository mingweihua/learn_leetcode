package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques6 {

	public static void main(String[] args) {
		//char[] chars = new char[1];
		System.out.println();
	}

	public static String convert(String s, int numRows) {
		if (s.length() == 0 || s.length() == 1 || s == null || numRows == 1) {
			return s;
		}
		int length = s.length();
		int numCols = 1
				+ ((length - numRows) / ((numRows - 1) * 2) + ((length - numRows) % ((numRows - 1) * 2) == 0 ? 0 : 1))
						* (numRows - 1);
		char[][] chars = new char[numRows][numCols];
		
		for (int i = 0; i < s.length(); i++) {
			int num = i / (numRows - 1);
			int mod = i % (numRows - 1);
			if (num % 2 == 0) {
				chars[mod][num/2*(numRows - 1)] = s.charAt(i);
			} else {
				int sum = (num+1)/2*(numRows - 1);
				int row = numRows - 1 - mod;
				chars[row][sum-row] = s.charAt(i);
			}
		}
		StringBuilder newSB = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[i].length; j++) {
				if (chars[i][j]!=0) {
					newSB.append(chars[i][j]);
				}
			}
		}
		
		return newSB.toString();	
	}
	
	//巧妙答案
	public static String convert2(String s, int numRows) {
		if (numRows < 2)
			return s;
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++)
			rows.add(new StringBuilder());
		int i = 0, flag = -1;
		for (char c : s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1)
				flag = -flag;
			i += flag;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows)
			res.append(row);
		return res.toString();
	}
}
