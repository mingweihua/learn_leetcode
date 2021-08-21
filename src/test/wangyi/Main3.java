package test.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str == null || str.length() == 0){
            System.out.println(0);
            return;
        }
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(nums_str[i]);
        }

        System.out.println(solve(nums));
    }

    public static int solve(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int[] papers = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        if(nums[0]<=nums[1] && nums[0]<=nums[nums.length-1]){
            list.add(0);
        }
        for (int i = 1; i <= nums.length-1; i++) {
            if(i == nums.length-1){
                if(nums[i]<=nums[0] && nums[i]<=nums[i-1]){
                    list.add(i);
                }
            } else {
                if(nums[i]<=nums[i+1] && nums[i]<=nums[i-1]){
                    list.add(i);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            papers[list.get(i)] = 1;
        }
        int end = list.get(0);
        int start = (end == nums.length-1?0:end+1);
        int pre = end;
        int next = (start == nums.length-1?0:start+1);
        while (start != end){
            if(papers[start] != 0){
                start = (start == nums.length-1?0:start+1);
                pre = (pre == nums.length-1?0:pre+1);
                next = (next == nums.length-1?0:next+1);
                continue;
            }
            if(papers[next]!=0){
                if(nums[pre] == nums[start]){
                    papers[start] = Math.max(papers[pre],papers[next]+(nums[start]==nums[next]?0:1));
                } else {
                    papers[start] = papers[pre] + 1;
                }
            } else {
                if(nums[pre] == nums[start]){
                    papers[start] = papers[pre];
                } else {
                    papers[start] = papers[pre] + 1;
                }
            }
            start = (start == nums.length-1?0:start+1);
            pre = (pre == nums.length-1?0:pre+1);
            next = (next == nums.length-1?0:next+1);
        }
        int sum = 0;
        for (int i = 0; i < papers.length; i++) {
            sum += papers[i];
        }
        return sum;
    }

}
