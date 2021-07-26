package leetcode;


import java.util.*;

public class Ques1713 {

    public static void main(String[] args) {
        int[] target = {147006006,414087855,781906580,213872647,341866400,674590438,530308968,178008557,87329397,886710682};
        int[] arr = {530308968,147006006,672718815,341866400,886710682,341866400,530308968,178008557,6513508,6513508};
        System.out.println(new Ques1713().minOperations3(target,arr));
    }


    //显示超出内存限制
    public int minOperations(int[] target, int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < target.length; i++) {
            set.add(target[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        int n = target.length;
        int m = list.size();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if(target[i-1] == list.get(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return n - dp[n][m];
    }


    //优化dp数组,空间达标了，但是会超出时间限制
    public int minOperations2(int[] target, int[] arr) {
        int n = target.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < target.length; i++) {
            set.add(target[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        set = null;
        int m = list.size();
        int[] dp = new int[m+1];
        int[] dp2;
        for (int i = 1; i <= n ; i++) {
            dp2 = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if(target[i-1] == list.get(j-1)){
                    dp2[j] = dp[j-1] + 1;
                } else {
                    dp2[j] = dp[j-1];
                }
                dp2[j] = Math.max(dp2[j],Math.max(dp[j],dp2[j-1]));
            }
            dp = dp2;
        }
        return n - dp[m];
    }

    //Leetcode的答案
    /*
        我的思路是没错的，使用的是最长子序列，最后通过n-最长子序列值极为答案；
        但是通过使用动态规划方法，该时间复杂度是O(nm)，超时；

        leetcode答案是将arr映射成target的下标（用上条件target互不相等），问题即转化为最长递增子序列（又是一个经典问题），
        简化时间复杂度。
     */
    public int minOperations3(int[] target, int[] arr) {
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
