package baodian;

import java.util.Arrays;

public class Ques1708 {
    /*
    按照身高升序，相同身高的按照体重降序进行排序后，这个问题变成了求体重数组的最长升序子序列（LIS）的问题。
     */

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] hw = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            hw[i][0] = height[i];
            hw[i][1] = weight[i];
        }
        Arrays.sort(hw,(int[] o1,int[] o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int[] dp = new int[height.length];
        dp[0] = 0;
        int cur = 0;
        for (int i = 1; i < height.length; i++) {
            if(hw[i][1] == hw[dp[cur]][1]){
                continue;
            }
            int temp = hw[i][1];
            if (temp > hw[dp[cur]][1]){
                dp[++cur] = i;
            } else {
                int left = 0;
                int right = cur;
                int mid = 0;
                while (left<right){
                    mid = left + ((right-left)>>1);
                    if(hw[dp[mid]][1] >= temp){
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                dp[left] = i;
            }
        }
        return cur+1;
    }
}
