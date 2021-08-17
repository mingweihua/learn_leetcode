package key.LCS_LIS;

public class LengthOfLIS {


    /*

        对应Leetcode的300题

     */


    /*
        方法一：动态规划

        定义 \textit{dp}[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度

        时间复杂度为O(n*n)，在一些题目中有可能会超时,这里就不再列出
     */


    /*
        方法二：贪心+二分
        考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。

        基于上面的贪心思路，我们维护一个数组 d[i] ，表示长度为 i 的最长上升子序列的末尾元素的最小值，用 len 记录目
        前最长上升子序列的长度，起始时 len为 1，d[1] =nums[0]。

     */

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
