package jianZhiOffer;

public class Ques42 {



    //前缀和思想，这里优化了一下空间复杂度
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        int preMin = Math.min(0,nums[0]);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,sum-preMin);
            preMin = Math.min(preMin,sum);
        }
        return max;
    }

}
