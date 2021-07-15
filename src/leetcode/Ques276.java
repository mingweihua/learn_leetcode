package leetcode;

public class Ques276 {

	public static void main(String[] args) {

	}

	public int numWays(int n, int k) {
		if(k==1){
			return n<=2?1:0;
		}
		int[][] dp = new int[n+1][2];
		dp[1][0] = 0;
		dp[1][1] = k;

		for (int i = 2; i <= n ; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][1] = (dp[i-1][1] + dp[i-1][0]) * (k-1);
		}
		return dp[n][0] + dp[n][1];
	}
}
