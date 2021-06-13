package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques1449 {

	public static void main(String[] args) {
		int[] cost = {4,3,2,5,6,7,2,5,5};
		int target = 9;
		System.out.println(new Ques1449().largestNumber(cost, target));	
	}
	
	public String largestNumber(int[] cost, int target) {
		int[][] dp = new int[cost.length+1][target+1];
		//dp[0][0] = 1;
		int score = 0;
		for (int i = 1; i < dp.length; i++) {
			score = cost[i-1];
			for(int j=1;j <=target;j++) {
				if(score>j) {
					dp[i][j] = dp[i-1][j];	
				} else {
					if(j-score==0 || dp[i][j-score]!=0) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-score]+1);
					} else {
						dp[i][j] = dp[i-1][j];
					}	
				}
			}
		}
		//int length = dp[cost.length][target];
		StringBuilder sb = new StringBuilder();
		int row = cost.length;
		int col = target;
		while(dp[row][col] != 0) {
			score = cost[row-1];
			if(dp[row][col] == dp[row][col-score]+1) {
				sb.append(row);
				col = col-score;
			} else {
				row = row - 1;
			}
		}
		
		score = 0;
		/*List<StringBuilder> dps = new ArrayList<StringBuilder>();
		for (int i = 0; i <= target; i++) {
			dps.add(new StringBuilder());
		}
		
		for (int i = 0; i < cost.length; i++) {
			score = cost[i];
			for(int j=score;j <=target;j++) {
				int pre = dps.get(j).length();
				int cur = dps.get(j-score).length()+1;
				if(cur >= pre) {
					dps.remove(j);
					dps.add(j, new StringBuilder(dps.get(j-score).toString()).append(i+1));
				}
			}
		}*/
		List<String> dps = new ArrayList<String>();
		for (int i = 0; i <= target; i++) {
			dps.add("");
		}
		
		for (int i = 0; i < cost.length; i++) {
			score = cost[i];
			for(int j=score;j <=target;j++) {
				int pre = dps.get(j).length();
				int cur = dps.get(j-score).length()+1;
				if(cur >= pre && (j-score==0 || dps.get(j-score).length()>0)) {
					dps.remove(j);
					dps.add(j, ""+(i+1)+dps.get(j-score));
				}
			}
		}
		return dps.get(target).length() == 0?"0" : dps.get(target);
    }
	
	//优化一下空间
	public String largestNumber2(int[] cost, int target) {
		int score = 0;
		List<StringBuilder> dps = new ArrayList<StringBuilder>();
		for (int i = 0; i <= target; i++) {
			dps.add(new StringBuilder());
		}
		
		for (int i = 0; i < cost.length; i++) {
			score = cost[i];
			for(int j=score;j <=target;j++) {
				int pre = dps.get(j).length();
				int cur = dps.get(j-score).length()+1;
				if(cur >= pre && (j-score==0 || dps.get(j-score).length()>0)) {
					dps.remove(j);
					dps.add(j, new StringBuilder(dps.get(j-score).toString()).append(i+1));
				}
			}
		}
		return dps.get(target).length() == 0?"0" : dps.get(target).reverse().toString();
	}
	
	public String largestNumber3(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c : cost) {
            for (int j = c; j <= target; ++j) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 8, j = target; i >= 0; i--) {
            for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }

}
