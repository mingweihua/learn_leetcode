package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Ques46 {
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> res = new Ques46().permute(arr);
		for (List<Integer> one : res) {
			for(Integer e : one) {
				System.out.println(e);
			}
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return res;
        }
        LinkedHashSet<Integer> oneRes = new LinkedHashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	oneRes.add(nums[i]);
            dfs(res,nums,oneRes);
        	oneRes.remove(nums[i]);
        }
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums,LinkedHashSet<Integer> oneRes){
        if(oneRes.size() == nums.length){
            res.add(new ArrayList<Integer>(oneRes));
            return;
        }

        for(int i=0;i<nums.length;i++){
        	if(!oneRes.contains(nums[i])) {
        		oneRes.add(nums[i]);
        		dfs(res,nums,oneRes);
        		oneRes.remove(nums[i]);
        	}
        }
        
    }
}
