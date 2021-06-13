package leetcode;

import java.util.Arrays;

public class Ques518 {

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1, 2, 5};
		System.out.println(new Ques518().change(amount, coins));
	}
	
	public int change(int amount, int[] coins) {
		Arrays.sort(coins);
		int[] dp = new int[amount+1];
		dp[0] = 1;
		int temp = 0;
		for(int i=0;i<coins.length;i++) {
			temp = coins[i];			
			for (int j = temp; j < dp.length; j++) {	
				if(j>=temp) {
					dp[j] += dp[j-temp];
				}
				
			}
		}
		return dp[amount];
    }
}
