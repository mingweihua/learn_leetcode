package baodian;

public class Ques0801 {



    public int waysToStep(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n ; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % mod;
        }
        return (int)dp[n];
    }

    public int waysToStep2(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        int mod = 1000000007;
        long a = 1;
        long b = 2;
        long c = 4;
        long d = 0;
        for (int i = 4; i <= n ; i++) {
            d = (a+b+c) % mod;
            a = b;
            b = c;
            c = d;
        }
        return (int)d;
    }
}
