package leetcode;


public class Ques188 {
	
	public static void main(String[] args) {

	}
	
	public int maxProfit(int k, int[] prices) {
		if (prices.length==0 || k==0) {
			return 0;
		}
		int[] dp = new int[2*k];
		for (int i = 0; i < dp.length; i+=2) {
			dp[i] = -prices[0];
		}
		for (int i = 1; i < prices.length; i++) {
			dp[0] = Math.max(dp[0], -prices[i]);
			dp[1] = Math.max(dp[1], dp[0]+prices[i]);
			for (int j = 1; j < k; j++) {
				dp[j*2] = Math.max(dp[j*2], dp[j*2-1]-prices[i]);
				dp[j*2+1] = Math.max(dp[j*2+1], dp[j*2]+prices[i]);
			}
		}
		return dp[2*k-1] ;
    }
	
	public int maxProfit2(int k, int[] prices) {
		if (prices.length==0 || k==0) {
			return 0;
		}
		int[] dp_pre = new int[2*k];
		for (int i = 0; i < dp_pre.length; i+=2) {
			dp_pre[i] = -prices[0];
		}
		int[] dp;
		for (int i = 1; i < prices.length; i++) {
			dp = new int[2*k];
			dp[0] = Math.max(dp_pre[0], -prices[i]);
			dp[1] = Math.max(dp_pre[1], dp_pre[0]+prices[i]);
			for (int j = 1; j < k; j++) {
				dp[j*2] = Math.max(dp_pre[j*2], dp_pre[j*2-1]-prices[i]);
				dp[j*2+1] = Math.max(dp_pre[j*2+1], dp_pre[j*2]+prices[i]);
			}
			dp_pre = dp;
		}
		return dp_pre[2*k-1] ;
    }
}
