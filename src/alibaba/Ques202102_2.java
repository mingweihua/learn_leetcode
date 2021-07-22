package alibaba;

import java.util.Scanner;

public class Ques202102_2 {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sb = new StringBuilder();

        if(n == m){
            for (int i = 1; i <= n ; i++) {
                sb.append(i);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        } else {
            solve(1,0,n,m);
        }
    }

    public static void solve(int cur,int length,int n,int m){

        if (length == m){
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
            return;
        }

        if(cur>n){
            return;
        }

        for (int i = cur; i <= n; i++) {
            sb.append(i);
            sb.append(" ");
            solve(i+1,length+1,n,m);
            sb.delete(sb.lastIndexOf(String.valueOf(i)),sb.length());
        }

    }


}
