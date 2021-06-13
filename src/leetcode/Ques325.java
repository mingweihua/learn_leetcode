package leetcode;

import java.util.HashMap;

public class Ques325 {

	public static void main(String[] args) {
		int[] arr = {1,1,0};
		int a=1;
		System.out.println(new Ques325().maxSubArrayLen(arr,a));
	}
	
	public int maxSubArrayLen(int[] nums, int k) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for(int i=0;i<nums.length;i++) {
        	dp[i+1] = dp[i] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(dp[0]+k,0);
        int res = 0;
        for(int i=1;i<=nums.length;i++) {
        	if(map.containsKey(dp[i])) {
        		res = Math.max(res, i-map.get(dp[i]));
        		if(!map.containsKey(dp[i]+k)) {
        			map.put(dp[i]+k, i);
        		}
        	} else {
        		if(!map.containsKey(dp[i]+k)) {
        			map.put(dp[i]+k, i);
        		}
        	}
        }
        return res;
    }
}
