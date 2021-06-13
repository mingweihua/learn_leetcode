package leetcode;

public class Ques487 {
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,
				1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1};
		
		System.out.println(new Ques487().findMaxConsecutiveOnes(nums));
	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int pre_0 = -1;
		int len = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == 0) {
				max = Math.max(max, len);
				len  = i-pre_0;
				pre_0 = i;
			} else {
				len++;
			}
		}
		max = Math.max(max, len);
		return max;
    }
}
