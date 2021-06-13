package leetcode;

public class Ques53 {

	public static void main(String[] args) {
		
	}
	
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] M = new int[nums.length];
        M[0] = nums[0] > 0? nums[0] : 0;
        int max = M[0];
        for(int i=1;i<nums.length;i++){
            M[i] = (M[i-1] + nums[i])>0?(M[i-1] + nums[i]):0;
            max = M[i]>max?M[i]:max;
        }
        if(max == 0){
            max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
            	max = max>nums[i]?max:nums[i];
            }
        }
        return max;
    }
	
	public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] M = new int[nums.length];
        M[0] = nums[0];
        int max = M[0];
        for(int i=1;i<nums.length;i++){
            M[i] = (M[i-1] + nums[i])>nums[i]?(M[i-1] + nums[i]):nums[i];
            max = M[i]>max?M[i]:max;
        }
        return max;
    }
}
