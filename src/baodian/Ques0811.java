package baodian;


public class Ques0811 {

    public static void main(String[] args) {
        System.out.println(new Ques0811().waysToChange(15));
    }

    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n ; i++) {
                dp[i] = (dp[i] + dp[i-coin])%mod;
            }
        }

        
        return dp[n];
    }
}
