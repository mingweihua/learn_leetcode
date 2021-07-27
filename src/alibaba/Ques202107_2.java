package alibaba;

import java.util.Scanner;

public class Ques202107_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[3][n];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                dp[i][j] = Long.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    dp[i][j] = Math.min(dp[i][j],dp[k][j-1] + Math.abs(a[k][j-1] - a[i][j]));
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res,dp[i][n-1]);
        }
        System.out.println(res);
    }





}
