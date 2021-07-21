package alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Ques202103 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solve(m,n));
    }

    public static long solve(int m,int n){
        long[][] dp = new long[n+1][m+1];
        Arrays.fill(dp[0],1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                for (int k = 0; k < i ; k++) {
                    dp[i][j] = (dp[i][j] + (dp[k][j-1] * dp[i-k-1][j-1] % mod)) % mod;
                }
            }
        }
        return dp[n][m];
    }
}
