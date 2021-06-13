package leetcode;

public class Ques879 {

	public static void main(String[] args) {
		
	}
	
	int res = 0;
	int mod = (int)Math.pow(10, 9) + 7;
	//超出时间限制了
	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		if(minProfit == 0){
            res++;
        }
		for (int i = 0; i < profit.length; i++) {
			profitableSchemes(n,minProfit,group,profit,i,0+profit[i],0+group[i]);
		}
		return res;
    }	
	
	public void profitableSchemes(int n, int minProfit, int[] group, int[] profit, int cur_index, int cur_P, int cur_g) {
		if(cur_g>n) {
			return;
		}
		if(cur_g <= n && cur_P >= minProfit) {
			res = (res+1) % mod;
		}
		if(cur_index == profit.length-1) {
			return;
		}
		for (int i = cur_index+1; i < profit.length; i++) {
			profitableSchemes(n,minProfit,group,profit,i,cur_P+profit[i],cur_g+group[i]);
		}
    }
	
	
	public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
		int len = group.length, MOD = (int)1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < members) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }
}
