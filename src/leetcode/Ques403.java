package leetcode;

public class Ques403 {
	
	
	public static void main(String[] args) {
		int[] arr = {0,1,3,5,6,8,12,17};
		System.out.println(new Ques403().canCross2(arr));
	}
	
	//n*n*n 超出时间限制
	public boolean canCross(int[] stones) {
		if(stones.length==2) {
			return stones[1] == 1;
		}
		int pre = 0;
		int step = 0;
		
		boolean[][] dp = new boolean[stones.length][stones.length];
		dp[0][1] = true;
		for(int i=2;i<stones.length;i++) {
			pre = i-1;
			while(pre > 0) {
				step = stones[i] - stones[pre];
				int row = pre - 1;
				while(row>=0 && row+3 >= pre) {
					if(dp[row][pre] && 
							(step>=stones[pre]-stones[row]-1  && step<= stones[pre]-stones[row]+1)
							) {
						dp[pre][i] = true;
						break;
					}
					row--;
				}
				pre--;
			}		
		}
		
		for(int i=stones.length-2;i>=0;i--) {
			if(dp[i][stones.length-1]) {
				return true;
			}
		}
		return false;
    }
	
	/*
	 * 我们也可以使用动态规划的方法，令 \textit{dp}[i][k]dp[i][k] 表示青蛙能否达到「现在所处的石子编号」为 ii 
	 * 且「上一次跳跃距离」为 kk 的状态。

	 */
	public boolean canCross2(int[] stones) {
		if(stones.length==2) {
			return stones[1] == 1;
		}
		boolean[][] dp = new boolean[stones.length][stones.length];
		dp[0][0] = true;
        for(int i=1;i<stones.length;i++){
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

		int k = 0;
		for(int i=1;i<stones.length;i++) {
			for(int j=i-1;j>=0;j--) {
				k = stones[i] - stones[j];
				if (k > j + 1) {
                    break;
                }
				dp[i][k] = (dp[j][k-1] || dp[j][k] || dp[j][k+1]);
                if(dp[i][k] && i == stones.length-1) {
                    return true;
                }
			}
		}
		
		return false;
		
    }
}
