package test.meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            A[i] = sc.nextInt();
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= n/2 ; i++) {
            if(A[i] != A[i+n/2]){
                list1.add(A[i]);
                list2.add(A[i+n/2]);
            }
        }
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
            int num1 = list1.get(i);
            int num2 = list2.get(i);
            String str1 = new String(""+num1+","+num2);
            String str2 = new String(""+num2+","+num1);
            if(set.contains(str1) || set.contains(str2)){
                continue;
            } else {
                res++;
                set.add(str1);
                set.add(str2);
            }
        }
        System.out.println(res);
    }


}


