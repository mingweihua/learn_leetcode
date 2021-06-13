package leetcode;

public class Ques123 {

	public static void main(String[] args) {
		int[] prices = {3,2,6,5,0,3};
		System.out.println(new Ques123().maxProfit(prices));
	}
	
	/*public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
		dp[0][0] = 0;
		dp[0][1] = - prices[0];
		
		for(int i=1;i<prices.length;i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
		}
		
		return dp[prices.length-1][0];
    }*/
	
	public int maxProfit(int[] prices) {
		if(prices.length==1) {
			return 0;
		}
		int sell1 = 0;
		int buy1 = -prices[0];
		int sell2 = 0;
		int buy2 = -prices[0];
		for(int i=1;i<prices.length;i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1-prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
    }

}
