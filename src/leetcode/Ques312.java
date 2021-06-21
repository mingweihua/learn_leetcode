package leetcode;


public class Ques312 {

	public static void main(String[] args) {
		
	}
	
	
	//戳气球，困难题，看答案才会
	public int maxCoins(int[] nums) {
		int[] val = new int[nums.length+2];
		val[0] = 1;
		val[nums.length+1] = 1;
		for (int i = 0; i < nums.length; i++) {
			val[i+1] = nums[i];
		}
		int n = val.length;
		int[][] dp = new int[n][n];
		for (int i = n-3; i >= 0  ; i--) {
			for (int j = i+2; j < n; j++) {
				for (int k = i+1; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j],dp[i][k] + val[i]*val[k]*val[j] + dp[k][j] );
				}
			}
		}
		return dp[0][n-1];
	}
	
}
