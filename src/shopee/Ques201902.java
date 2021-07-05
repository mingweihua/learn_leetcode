package shopee;

import java.util.Scanner;

public class Ques201902 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solve(nums,m));
    }

    public static int solve(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            left = Math.max(left,nums[i]);
        }

        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(check(nums,mid,m)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static boolean check(int[] nums, int max, int m){
        int cur = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i] <= max){
                sum += nums[i];
            } else {
                sum = nums[i];
                cur++;
            }
        }
        return cur <= m;
    }

}
