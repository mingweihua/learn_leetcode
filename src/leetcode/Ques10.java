package leetcode;

public class Ques10 {

	public static void main(String[] args) {
		System.out.println(new Ques10().isMatch("aaa", "a*a"));
	}

	// 很难，最后看答案，动态规划
	public boolean isMatch(String s, String p) {

		int m = s.length();
		int n = p.length();

		boolean[][] match = new boolean[m + 1][n + 1];
		match[0][0] = true;

		for (int i = 0; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 0) {
					if (p.charAt(j - 1) == '*') {
						match[i][j] = match[i][j - 2];
					}
					continue;
				}
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					match[i][j] = match[i - 1][j - 1];
					continue;
				}
				if (p.charAt(j - 1) == '*') {
					if (match[i][j - 2]) {
						match[i][j] = true;
					} else {
						match[i][j] = (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && match[i - 1][j];
					}
				}
			}
		}

		return match[m][n];
	}

}
