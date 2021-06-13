package leetcode;

public class Ques1269 {

	public static void main(String[] args) {
		
	}
	
	
	public int numWays(int steps, int arrLen) {
		final int MODULO = 1000000007;
		int[][] dp = new int[steps+1][arrLen];
		dp[0][0] = 1;
		for(int i=1;i<=steps;i++) {
			for(int j=0;j<arrLen;j++) {
				if(j>i) {
					break;
				}
				
				dp[i][j] = (dp[i][j] + dp[i-1][j])%MODULO;
				if(j-1>=0) {
					dp[i][j] = (dp[i][j] + dp[i-1][j-1])%MODULO;
				}
				if(j+1<arrLen) {
					dp[i][j] = (dp[i][j] + dp[i-1][j+1])%MODULO;
				}
			}
		}
		
		return dp[steps][0];
    }
	
	public int numWays2(int steps, int arrLen) {
		final int MODULO = 1000000007;
		int[] dp = new int[arrLen];
		dp[0] = 1;
		for(int i=1;i<=steps;i++) {
			int[] temp = new int[arrLen];
			for(int j=0;j<arrLen;j++) {
				if(j>i) {
					break;
				}			
				temp[j] = dp[j];
				if(j-1>=0) {
					temp[j] = (temp[j] + dp[j-1])%MODULO;
				}
				if(j+1<arrLen) {
					temp[j] = (temp[j] + dp[j+1])%MODULO;
				}
			}
			dp = temp;
		}
		return dp[0];
    }
	

}
