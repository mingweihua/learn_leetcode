package alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Ques202106_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }


    public static String solve(int[] arr){
        long res = 0L;
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = arr.length - 1;
        int pre = arr[left];
        res += Math.abs(arr[right] - pre);
        sb.append(pre);
        sb.append(" ");
        left++;
        pre = arr[right];
        boolean flag = true;
        while (left<right){
            if(flag){
                res += Math.abs(arr[left] - pre);
                sb.append(pre);
                sb.append(" ");

                pre = arr[left];
                right--;

                flag = false;
            } else {
                res += Math.abs(arr[right] - pre);
                sb.append(pre);
                sb.append(" ");

                pre = arr[right];
                left++;

                flag = true;
            }
        }
        //left == right
        res += Math.abs(arr[right] - pre);
        sb.append(pre);

        pre = arr[right];
        res += Math.abs(arr[0] - pre);

        System.out.println(res);
        return sb.toString();
    }


}
