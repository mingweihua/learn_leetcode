package leetcode;


public class Ques421 {
	
	
	public static void main(String[] args) {
		
	}
	
	//暴力解法
	public int findMaximumXOR(int[] nums) {
		if(nums.length==1) {
			return 0;
		}
		if(nums.length==2) {
			return nums[0] ^ nums[1];
		}
		int max = 0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				max = Math.max(nums[i]^nums[j], max);
			}
		}
		return max;
    }
}
