package leetcode;

public class Ques413 {
	
	
	public static void main(String[] args) {

	}

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
	    int[] dp = new int[nums.length];
	    int preQ = nums[1] - nums[0];
	    int curLength = 2;
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if(preQ == nums[i] - nums[i-1]){
                curLength++;
                dp[i] = dp[i-1] + (curLength - 3 +1);
            } else {
                preQ = nums[i] - nums[i-1];
                sum += dp[i-1];
                curLength = 2;
            }
        }
        sum += dp[nums.length-1];
        return sum;
    }
}
