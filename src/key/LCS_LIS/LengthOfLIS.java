package key.LCS_LIS;

public class LengthOfLIS {


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
