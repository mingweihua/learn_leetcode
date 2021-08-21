package test.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums_str = sc.nextLine().split(" ");
        int M = Integer.valueOf(sc.nextLine());
        int[] nums = new int[nums_str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(nums_str[i]);
        }

        System.out.println(solve(nums,M));
    }

    public static int solve(int[] nums,int M){
        int res = 0;
        Arrays.sort(nums);
        boolean flag = false;
        for (int i = nums.length-1; i >=1 ; i--) {
            if(flag){
                res += i;
                continue;
            }
            int cur = nums[i];
            if(cur + nums[i-1] <= M){
                flag = true;
                res += i;
            } else {
                int target = M - cur;
                int left = 0;
                int right = i-1;
                int mid = 0;
                while (left < right){
                    mid = left + ((right - left)>>1);
                    if(nums[mid]>target){
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                res += left;
            }
        }
        return res;
    }

}
