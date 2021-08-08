package test.meituan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n+1];
            for (int j = 0; j < n; j++) {
                nums[sc.nextInt()]++;
            }
            int cur = 0;
            int index = 0;
            for (; index <=n ; index++) {
                cur += nums[index];
                if(cur >= k){
                    break;
                }
            }
            index++;
            if(cur == k && index <= n){
                System.out.println("YES");
                System.out.println(index);
            } else {
                System.out.println("NO");
            }
        }
    }

}


