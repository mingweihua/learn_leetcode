package leetcode;

public class Ques1646 {

	public static void main(String[] args) {
		System.out.println(new Ques1646().getMaximumGenerated(7));
	}


	public int getMaximumGenerated(int n) {
		if(n<=1){
			return n;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		int max = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i/2] + (i%2)*dp[i/2+1];
			max = Math.max(max,dp[i]);
		}
		return max;
	}
}
