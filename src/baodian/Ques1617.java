package baodian;

public class Ques1617 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }

}
