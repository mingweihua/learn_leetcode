package alibaba;

import java.util.Scanner;

public class Ques202104_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcb = gcd(a,b);
        a /= gcb;
        b /= gcb;
        // 然后计算unit
        int unit = Math.min(A / a, B / b);
        System.out.println((a*unit) + " " + (b*unit));
    }



    public static int gcd(int a, int b){
        if(b>a){
            int temp = a;
            a = b;
            b = temp;
        }
        int left = a % b;
        while (left != 0){
            a = b;
            b = left;
            left = a % b;
        }
        return b;
    }
}
