package shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ques202104 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(solve(str));
    }

    static int[] pre_nums;
    static int[] in_nums;
    static List<Integer> nums;
    public static String solve(String str){
       String[] strs = str.split(" ");
        if(strs.length == 1){
            return strs[0];
        }
        pre_nums = new int[strs.length];
        in_nums = new int[strs.length];
        for (int i = 0; i < pre_nums.length; i++) {
            pre_nums[i] = Integer.valueOf(strs[i]);
        }
        in_nums = pre_nums.clone();
        Arrays.sort(in_nums);

        nums = new ArrayList<>();

        int pre_start = 0;
        int in_start = 0;
        int in_mid = 0;
        while (in_nums[in_mid] != pre_nums[pre_start]) {
            in_mid++;
        }
        dfs(pre_start+1,pre_start + in_mid - in_start,in_start,in_mid-1);
        dfs(pre_start + in_mid - in_start+1, pre_start- in_start +in_nums.length-1 ,in_mid+1,in_nums.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void dfs(int pre_start, int pre_end,int in_start,int in_end) {
        if(pre_start>pre_end){
            return;
        }
        if(pre_end == pre_start){
            nums.add(pre_nums[pre_start]);
            return;
        }
        int in_mid = in_start;
        while (in_nums[in_mid] != pre_nums[pre_start]) {
            in_mid++;
        }
        dfs(pre_start+1,pre_start + in_mid - in_start,in_start,in_mid-1);
        dfs(pre_start + in_mid - in_start+1, pre_start- in_start +in_end ,in_mid+1,in_end);
    }

}
