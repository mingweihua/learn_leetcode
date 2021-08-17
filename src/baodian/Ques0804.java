package baodian;

import java.util.ArrayList;
import java.util.List;

public class Ques0804 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Ques0804().subsets(nums));
    }

    ArrayList<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        res.add(new ArrayList<>());
        for (int length = 1; length <= n; length++) {
            dfs(nums,length,new ArrayList<>(),0);
        }

        return res;
    }

    public void dfs(int[] nums,int length,List<Integer> pre,int cur){
        if(pre.size() == length){
            res.add(new ArrayList<>(pre));
            return;
        }

        if(length - pre.size()>nums.length - cur){
            return;
        }
        if(cur>=nums.length){
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            pre.add(nums[i]);
            dfs(nums,length,pre,i+1);
            pre.remove(pre.size()-1);
        }
    }
}
