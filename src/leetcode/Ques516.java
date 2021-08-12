package leetcode;

public class Ques516 {

	public static void main(String[] args) {

	}

	 /*
        对应leetcode的是516题，最长回文子序列
     */
	//动态规划，会做最长回文连续的子序列，但是子序列就不知道当不等于时怎么转移


	//官方答案。当不相等的时候，i,j不可能同时作为同一个回文子序列的首尾,因此dp[i][j] = max(dp[i+1][j],dp[i][j-1]);

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (int i = n-2; i >=0 ; i--) {
			for (int j = i+1; j < n; j++) {
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}

		return dp[0][n-1];
	}

	/*
        另外看到一个人发的答案，思路很好，把字符串倒转后，就是查询最长公共子序列问题，LCS
     */
	public int longestPalindromeSubseq2(String s) {
		int n = s.length();
		String s2 = new StringBuilder(s).reverse().toString();
		int[][] dp = new int[n+1][n+1];

		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				if(s.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[n][n];
	}
}
