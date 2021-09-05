package baodian;

import java.util.Arrays;

public class Ques1011 {

    public static void main(String[] args) {

    }

    public void wiggleSort(int[] nums) {
        if(nums.length<=1){
            return;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int right = nums.length-1;
        int left = 0;
        int cur = 0;
        while (left<right){
            dp[cur++] = nums[right--];
            if(right == left){
                break;
            }
            dp[cur++] = nums[left++];
        }
        dp[cur] = nums[left];
        for (int i = 0; i < dp.length; i++) {
            nums[i] = dp[i];
        }
    }
}
