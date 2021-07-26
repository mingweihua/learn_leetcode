package key.LCS_LIS;

public class LCS {

    /*
        最长公共子序列
        对应Leetcode的1143题

     */

    //普通的dp这里不写，写了是压缩dp空间的方法
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int n = arr1.length;
        int m = arr2.length;

        int[] dp = new int[m + 1];
        int[] dp2;
        for (int i = 1; i <= n; i++) {
            dp2 = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp2[j] = dp[j - 1] + 1;
                } else {
                    dp2[j] = dp[j - 1];
                }
                dp2[j] = Math.max(dp2[j], Math.max(dp[j], dp2[j - 1]));
            }
            dp = dp2;
        }
        return dp[m];
    }
}
