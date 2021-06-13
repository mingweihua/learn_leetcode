package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques78 {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		new Ques78().subsets(arr);
	}


	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<=nums.length;i++){
            subsets(res,i,nums);
        }
        return res;
    }

    public void subsets(List<List<Integer>> res, int length,int[] nums) {
        if(length == 0) {
            res.add(new ArrayList<Integer>());
            return;
        }
        subsets(res,new ArrayList<Integer>(),0,length,nums);       
    }

    public void subsets(List<List<Integer>> res, List<Integer> pre, int cur, int length,int[] nums) {
        if(pre.size() == length){
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        for(int i=cur;i<nums.length;i++){
            pre.add(nums[i]);
            subsets(res,pre,i+1,length,nums);
            pre.remove(pre.size()-1);
        }
        
    }
    
    //优化空间复杂度了
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        ArrayList<Integer> pre = new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++){
        	dfs(res,pre,0,i,nums);
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> pre, int cur,int length,int[] nums) {
    	if(pre.size() == length){
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        for(int i=cur;i<nums.length;i++){
            pre.add(nums[i]);
            dfs(res,pre,i+1,length,nums);
            pre.remove(pre.size()-1);
        }     
    }
}
