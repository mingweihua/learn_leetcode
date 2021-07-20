package alibaba;

import java.util.Scanner;

public class Ques202102 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            int n = sc.nextInt();
            System.out.println(solve(a,b,n));
        }
    }

    public static long solve(long a,long b,int n){
        long[] dp = new long[n+1];
        dp[0] = 2;
        dp[1] = a;
        dp[2] = a * a - 2*b;
        for (int i = 3; i <= n; i++) {
            dp[i] = (a*(dp[i-1])%mod-b*(dp[i-2])%mod+mod)%mod;
        }
        return dp[n];
    }
}
