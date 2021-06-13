package leetcode;

public class Ques5 {

	public static void main(String[] args) {
		System.out.println(new Ques5().longestPalindrome2("cbbd"));
	}
	
	
	//中心扩展法
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int ll = 0;
		int rr = 0;
		int maxLength = 1;
		for (int i = 0; i < s.length(); i++) {
			int l = i - 1;
			int r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if ((r - l + 1) > maxLength) {
					maxLength = r - l + 1;
					ll = l;
					rr = r;
				}
				l--;
				r++;
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if ((r - l + 1) > maxLength) {
					maxLength = r - l + 1;
					ll = l;
					rr = r;
				}
				l--;
				r++;
			}
		}
		return s.substring(ll, rr + 1);
	}
	
	
	public String longestPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int length = s.length();
		int ll = 0;
		int rr = 0;
		int maxLength = 1;
		boolean[][] b = new boolean[length][length];
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {
				if (l == 1) {
					b[i][i] = true;
					continue;
				}
				int j = l - 1 + i;
				if(l == 2 && s.charAt(j) == s.charAt(i)) {
					b[i][j] = true;
					if (l > maxLength) {
						maxLength = l;
						ll = i;
						rr = j;
					}
					continue;
				}		
				if (j < length && s.charAt(j) == s.charAt(i) && b[i + 1][j - 1]) {
					b[i][j] = true;
					if (l > maxLength) {
						maxLength = l;
						ll = i;
						rr = j;
					}
				}
			}
		}
		return s.substring(ll, rr + 1);
	}
}
