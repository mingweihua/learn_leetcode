package shopee;

import java.util.HashSet;
import java.util.Scanner;

public class Ques201901 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = Integer.valueOf(strs[2]);

        long[][] dp = new long[Integer.valueOf(strs[0])+1][Integer.valueOf(strs[1])+1];
        int x =0;
        int y =0;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            dp[x][y] = -1;
        }
        for (int i = 0; i < dp.length; i++) {
            if(dp[i][0] == -1){
                break;
            }
            dp[i][0] = 1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if(dp[0][j] == -1){
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(dp[i][j] == -1){
                    continue;
                }
                if(dp[i-1][j] == -1 && dp[i][j-1] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if(dp[i-1][j] == -1 || dp[i][j-1] == -1){
                    dp[i][j] = dp[i-1][j] == -1?dp[i][j-1] : dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j]+ dp[i][j-1];
            }
        }

        System.out.println(dp[dp.length][dp[0].length]);
    }


}
