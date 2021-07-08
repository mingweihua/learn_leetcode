package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Ques930 {

    public static void main(String[] args) {

    }

	public int numSubarraysWithSum(int[] nums, int goal) {
		if(nums.length == 1){
			return nums[0] == goal?1:0;
		}
		int res = 0;
		int[] dp = new int[nums.length+1];
		dp[0] = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0,1);
		int temp = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1] + nums[i-1];
			res += map.getOrDefault(dp[i]-goal,0);
			map.put(dp[i],map.getOrDefault(dp[i],0)+1);
		}
		return res;
	}
}
