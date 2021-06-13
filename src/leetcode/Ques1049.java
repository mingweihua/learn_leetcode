package leetcode;

public class Ques1049 {

	public static void main(String[] args) {
		
	}

	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		int net = sum / 2;
		boolean[][] dp = new boolean[stones.length+1][net+1];
		dp[0][0] = true;
		int cur = 0;
		for (int i = 0; i < stones.length; i++) {
			cur = stones[i];
			for (int j = 0; j < dp[0].length; j++) {
				if(j<cur) {
					dp[i+1][j] = dp[i][j];
				} else {
					dp[i+1][j] = dp[i][j-cur] || dp[i][j];
				}
			}
		}
		for (int j = dp[0].length-1; j >=0; j--) {
			if(dp[stones.length][j]) {
				net = j;
				break;
			}
		}
		return sum - 2 * net;
    }
	
	
	public int lastStoneWeightII2(int[] stones) {
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		int net = sum / 2;
		boolean[] dp = new boolean[net+1];
		dp[0] = true;
		int cur = 0;
		for (int i = 0; i < stones.length; i++) {
			cur = stones[i];
			for (int j = dp.length -1; j >= 0; j--) {
				if(j<cur) {
					dp[j] = dp[j];
				} else {
					dp[j] = dp[j-cur] || dp[j];
				}
			}
		}
		for (int j = dp.length-1; j >=0; j--) {
			if(dp[j]) {
				return sum - 2 * j;
			}
		}
		return 0;
    }
}
