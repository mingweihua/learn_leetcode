package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Ques90 {

	public static void main(String[] args) {
		int[] arr = {1,2,2};
		new Ques90().subsetsWithDup(arr);
	}
	
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	HashSet<String> check = new HashSet<String>();
	List<Integer> pre = new ArrayList<Integer>(); 
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		res.add(new ArrayList<Integer>());
		if(nums.length==0) {
			return res;
		}
		Arrays.sort(nums);
		for(int i=1;i<=nums.length;i++) {
			addRes(nums,0,i);
		}
		return res;
    }
	
	public void addRes(int[] nums,int cur,int len) {
		if(len == 0) {
			if(!check.contains(pre.toString())) {
				res.add(new ArrayList<Integer>(pre));
				check.add(pre.toString());
			}
		}
		for(int i=cur;i<=nums.length-1;i++) {
			pre.add(nums[i]);
			addRes(nums,i+1,len-1);
			pre.remove(pre.size()-1);
		}
    }
}
