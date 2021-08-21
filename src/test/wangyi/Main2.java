package test.wangyi;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(new Main2().findKthBit(4,11));
    }


    public char findKthBit (int n, int k) {
        String[] dp = new String[n+1];
        dp[1] = "a";
        for (int i = 2; i <= n ; i++) {
            StringBuilder sb = new StringBuilder(dp[i-1]);
            sb.append((char)('a' + (i-1)));
            sb.append(reverseAndInvert(dp[i-1]));
            dp[i] = sb.toString();
        }

        return dp[n].charAt(k-1);
    }


    public String reverseAndInvert (String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp = chars[i] - 'a';
            chars[i] = (char) ('z'-temp);
        }
        StringBuilder res = new StringBuilder(new String(chars));
        return res.reverse().toString();
    }
}
