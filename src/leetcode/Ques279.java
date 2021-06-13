package leetcode;

public class Ques279 {

	public static void main(String[] args) {
		System.out.println(new Ques279().numSquares(53));
	}
	
	//超过时间限制
	public int res = Integer.MAX_VALUE;
	public int numSquares(int n) {
		int max = (int) Math.sqrt(n);
		for (int i = max; i>=1; i--) {
			solve(n-i*i,1);
		}
		return res;
    }
	
	public void solve(int left, int cur) {
		if(left == 0) {
			res = Math.min(res, cur);
			return;
		}
		
		int max = (int) Math.sqrt(left);
		for (int i = max; i>=1; i--) {
			solve(left-i*i,cur+1);
		}
    }
	
	public int numSquares2(int n) {
		int max = (int) Math.sqrt(n);
		if(max*max==n) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 2; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
			
			for(int j=1;j*j<=i;j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		return dp[n];
    }
}
