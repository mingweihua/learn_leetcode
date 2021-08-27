package leetcode;


public class Ques309 {

	public static void main(String[] args) {
		
	}
	
	
	public int maxProfit(int[] prices) {
		if(prices.length==0 || prices.length==1 ) {
			return 0;
		}
		int k = (int) Math.ceil(prices.length / 3.0);
		int[] dp_pre = new int[k*2];
        for (int i = 0; i < dp_pre.length; i+=2) {
			dp_pre[i] = -prices[0];
		}

		
		int[] dp = new int[k*2];
        dp[0] = Math.max(dp_pre[0], -prices[1]);
		dp[1] = Math.max(dp_pre[1], dp_pre[0]+prices[1]);
        for (int j = 1; j < k; j++) {
			dp[j*2] = Math.max(dp_pre[j*2], dp_pre[j*2-1]-prices[1]);
			dp[j*2+1] = Math.max(dp_pre[j*2+1], dp_pre[j*2]+prices[1]);
		}

		
		int[] temp;
		for (int i = 2; i < prices.length; i++) {
			temp = new int[k*2];
			temp[0] = Math.max(dp[0], -prices[i]);
			temp[1] = Math.max(dp[1], dp[0]+prices[i]);
			for (int j = 1; j < k; j++) {
				temp[j*2] = Math.max(dp[j*2], dp_pre[j*2-1]-prices[i]);
				temp[j*2+1] = Math.max(dp[j*2+1], dp[j*2]+prices[i]);
			}
			dp_pre = dp;
			dp = temp;
		}
		
		return dp[2*k-1];
    }
	
	public int maxProfit2(int[] prices) {
		if(prices.length==0 || prices.length==1 ) {
			return 0;
		}
		int[][] dp = new int[prices.length][3];
		dp[0][0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
		}
		return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }
	
	public int maxProfit3(int[] prices) {
		if(prices.length==0 || prices.length==1 ) {
			return 0;
		}
		int buy_pre=-prices[0],buy=0;
		int sell_pre=0,sell=0;
		int stop_pre=0,stop=0;
		for (int i = 1; i < prices.length; i++) {
			buy = Math.max(buy_pre, stop_pre-prices[i]);
			sell = Math.max(sell_pre, buy_pre+prices[i]);
			stop = Math.max(stop_pre, sell_pre);
			buy_pre = buy;
			sell_pre = sell;
			stop_pre = stop;
		}
		return Math.max(sell, stop);
    }

	public int maxProfit4(int[] prices) {
		if(prices.length<=1 ) {
			return 0;
		}
		int[][] dp = new int[prices.length][2];
		dp[0][0] = -prices[0];
		dp[1][0] = Math.max(-prices[1], dp[0][0]);
		dp[1][1] = Math.max(dp[0][0]+prices[1], dp[0][1]);
		for (int i = 2; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-2][1]-prices[i], dp[i-1][0]);
			dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
		}
		return dp[prices.length-1][1];
	}
	
}
