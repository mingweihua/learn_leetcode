package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ques368 {

	public static void main(String[] args) {
		int[] arr = {5,9,18,54,108,540,90,180,360,720};
		new Ques368().largestDivisibleSubset(arr);
	}
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int max = 1;
		int index_max = 0;
		int[] dp = new int[nums.length];
		int[] pre = new int[nums.length];
		dp[0] = 1;
		pre[0] = 0;
		for(int i=1;i<nums.length;i++) {
			int preIndex_max = i;
			int cur_length = 0;
			int cur_max = 1;
			for(int j=0;j<i;j++) {
				cur_length = 1;
				if(nums[j] %nums[i] == 0 || nums[i]%nums[j]==0) {
					cur_length += dp[j];
				}
				if(cur_length>cur_max) {
					cur_max = cur_length;
					preIndex_max = j;
				}
			}
			dp[i] = cur_max;
			pre[i] = preIndex_max;
			if(dp[i]>max) {
				max = dp[i];
				index_max = i;
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(pre[index_max] != index_max) {
			res.add(0, nums[index_max]);
			index_max = pre[index_max];
		}
		res.add(0, nums[index_max]);
		return res;
    }

}
