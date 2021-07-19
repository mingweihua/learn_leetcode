package leetcode;

import java.util.Arrays;

public class Ques1838 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,4,5,5};
		System.out.println(new Ques1838().maxFrequency(nums,5));
	}

	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length-1; i++) {
			dp[i] = nums[i+1] - nums[i];
		}
		int max = 0;
		int sum = 0;
		int cur = 1;
		while (cur<nums.length && nums[cur] == nums[cur-1]){
			cur++;
		}
		max = cur;
		int next,pre,left;
		while (cur<nums.length){
			next = cur + 1;
			while (next<nums.length && nums[next] == nums[next-1]){
				next++;
			}
			pre = cur - 1;
			left = k;
			sum = 0;
			while (pre>=0 && left>=sum + dp[pre]){
				sum += dp[pre];
				left -= sum;
				pre--;
			}
			max = Math.max(max,next - pre -1);
			cur = next;
		}
		return max;
	}
}
