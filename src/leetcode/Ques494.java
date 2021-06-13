package leetcode;

import java.util.HashMap;

public class Ques494 {
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int target = 0;
		System.out.println(new Ques494().findTargetSumWays3(nums, target));
	}
	

	public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(-nums[0],0)+1);
        HashMap<Integer, Integer> next;
        for (int i = 1; i < nums.length; i++) {
        	next = new HashMap<Integer, Integer>();
        	for(Integer key : map.keySet()) {
        		next.put(key-nums[i], next.getOrDefault(key-nums[i], 0)+map.get(key));
        		next.put(key+nums[i], next.getOrDefault(key+nums[i], 0)+map.get(key));
        	}
        	map = next;
		}
		return map.getOrDefault(target, 0);
    }
	
	
	//背包问题
	public int findTargetSumWays2(int[] nums, int target) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int t = sum - target;
		if(t<0 || t%2 != 0) {
			return 0;
		}
		t = t/2;
		int[][] dp = new int[nums.length+1][t+1];
		dp[0][0] = 1;
		int temp = 0;
		for (int i = 1; i < dp.length; i++) {
			temp = nums[i-1];
			for (int j = 0; j < dp[0].length; j++) {
				if(temp<=j) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-temp];
				} else {
					dp[i][j] = dp[i-1][j];
				}	
			}
		}
		return dp[nums.length][t];
    }
	
	//优化空间
	public int findTargetSumWays3(int[] nums, int target) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int t = sum - target;
		if(t<0 || t%2 != 0) {
			return 0;
		}
		t = t/2;
		int[] dp = new int[t+1];
		dp[0] = 1;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			temp = nums[i];
			for (int j = dp.length-1; j >= 0; j--) {
				if(temp<=j) {
					dp[j] += dp[j-temp];				
				}	
			}
		}
		return dp[t];
    }
}
