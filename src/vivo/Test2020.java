package vivo;

import java.util.Arrays;
import java.util.LinkedList;

public class Test2020 {



    //问题2
    private static String solution2(int[] input) {
        int n = input[0];
        int k = input[1];
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> tList;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int cur = 1;
        while(!list.isEmpty()){
            tList = new LinkedList<>();
            while (!list.isEmpty()){
                if(cur == k){
                    sb.append(list.remove());
                    sb.append(" ");
                    cur = 1;
                } else {
                    tList.add(list.remove());
                    cur++;
                }
            }
            list = tList;
        }

        return sb.toString();
    }

    //问题3
    private static int solution3(int[] input) {
        if(input.length==1){
            return 0;
        }
        if(input[0]>=input.length){
            return 1;
        }
        if(input[0]==0){
            return -1;
        }
        int[] dp = new int[input.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for (int j = 0; j < i; j++) {
                if(input[j]+j>=i){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[input.length-1] == Integer.MAX_VALUE?-1:dp[input.length-1];
    }
}
