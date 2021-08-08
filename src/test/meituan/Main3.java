package test.meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    /*
    12
1 1 1 3 7 3 7 5 6 5 7 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        int[] pre = new int[n+1];
        pre[1] = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A[1]);
        long sum = pre[1];
        for (int i = 2; i <= n; i++) {
            pre[i] = binarySearchAndAdd(list,A[i]);
            sum += (pre[i] * i);
        }

        if(n==0){
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }

    public static int binarySearchAndAdd(ArrayList<Integer> list,int target){
        int res = 0;
        if(target<=list.get(0)){
            list.add(0,target);
            return 0;
        }
        if(target > list.get(list.size()-1)){
            res = list.get(list.size()-1);
            list.add(target);
            return res;
        }
        int left = 0;
        int right = list.size()-1;
        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(list.get(mid) >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if(left>0){
            res = list.get(left-1);
        }
        list.add(left,target);
        return res;
    }

    public static int searchAndAdd(ArrayList<Integer> list,int target){
        int res = 0;
        if(target<=list.get(0)){
            list.add(0,target);
            return 0;
        }
        if(target > list.get(list.size()-1)){
            res = list.get(list.size()-1);
            list.add(target);
            return res;
        }
        int index = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if(list.get(i)<target){
                index = i;
                res = list.get(i);
                break;
            }
        }
        list.add(index+1,target);
        return res;
    }
}


