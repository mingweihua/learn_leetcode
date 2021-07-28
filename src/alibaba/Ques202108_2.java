package alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Ques202108_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] respect = new int[n+1];
        int[] scores = new int[n+1];
        Arrays.fill(scores,1);
        for (int i = 1; i <= n; i++) {
            respect[i] = sc.nextInt();
        }
        for (int i = n; i >=1 ; i--) {
            scores[respect[i]] += scores[i];
        }
        for (int i = 1; i <= n ; i++) {
            System.out.println(scores[i]);
        }
    }


}
