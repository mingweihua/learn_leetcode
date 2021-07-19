package leetcode;

public class Ques300 {

	public static void main(String[] args) {
		int[] nums = {1,2,-10,-8,-7};
		System.out.println(new Ques300().lengthOfLIS(nums));
	}
	
	//最长递增子序列，自己只想到了n*n复杂度动态规划的，答案是贪心+二分

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length+1];
		dp[1] = nums[0];
		int cur = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == dp[cur]){
				continue;
			} else if(nums[i] > dp[cur]){
				dp[++cur] = nums[i];
			} else {
				int left = 1;
				int right = cur;
				int mid = 0;
				while (left<right){
					mid = left + ((right-left)>>1);
					if(dp[mid] >= nums[i]){
						right = mid;
					} else {
						left = mid +1;
					}
				}
				dp[left] = nums[i];
			}
		}
		return cur;
	}
}
