package key.LCS_LIS;

import java.util.ArrayList;
import java.util.HashMap;

public class Ques1713 {

    public static void main(String[] args) {
        int[] target = {147006006,414087855,781906580,213872647,341866400,674590438,530308968,178008557,87329397,886710682};
        int[] arr = {530308968,147006006,672718815,341866400,886710682,341866400,530308968,178008557,6513508,6513508};
        System.out.println(new Ques1713().minOperations(target,arr));
    }

    //Leetcode的答案
    /*
        我的思路是没错的，使用的是最长公共子序列，最后通过n-最长公共子序列值极为答案；
        但是通过使用动态规划方法，该时间复杂度是O(nm)，超时；

        leetcode答案是将arr映射成target的下标（用上条件target互不相等），问题即转化为最长递增子序列（又是一个经典问题），
        简化时间复杂度。
     */
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i],i+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                list.add(map.get(arr[i]));
            }
        }
        int m = list.size();
        if( m == 0 || m == 1){
            return n-m;
        }
        int[] dp = new int[m+1];
        dp[1] = list.get(0);
        int len = 1;
        for (int i = 1; i < m; i++) {
            int temp = list.get(i);
            if(temp>dp[len]){
                dp[++len] = temp;
            } else {
                int left = 0;
                int right = len;
                int mid = 0;
                while (left<right){
                    mid = left + ((right-left)>>1);
                    if(dp[mid]>= temp){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                dp[left] = temp;
            }
        }

        return n - len;
    }
}
