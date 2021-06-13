package leetcode;

public class Ques474 {
	
	
	public static void main(String[] args) {
		
	}
	
	

	public int findMaxForm(String[] strs, int m, int n) {
		int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        int[] nums = null;
        for (int i = 1; i < dp.length; i++) {
        	nums = solve(strs[i-1]);
        	for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					dp[i][j][k] = dp[i-1][j][k];
					if(nums[0]<=j && nums[1]<=k) {
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-nums[0]][k-nums[1]]+1);
					}
				}
			}
		}
        return dp[length][m][n];
    }
	
	public int[] solve(String str) {
		int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '0') {
				res[0]++;
			} else {
				res[1]++;
			}
		}
        return res;
    }
}
