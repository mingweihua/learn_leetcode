package leetcode;


import java.util.Arrays;

public class Ques1877 {

	public static void main(String[] args) {

	}

	public int minPairSum(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length-1;
		int res = Integer.MIN_VALUE;
		while (left<right){
			res = Math.max(res,nums[left++]+ nums[right--]);
		}
		return res;
	}
}
