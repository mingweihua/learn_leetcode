package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques15 {

	public static void main(String[] args) {
		
	}

	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length < 3) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length-3; i++) {
			if(i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int first = i+1;
			int last = nums.length-1;
			int temp = 0 - nums[i];
			while(first<last) {
				if(first!=i+1 && nums[first] == nums[first-1]) {
					first++;
					continue;
				}
				if(last!=nums.length-1 && nums[last] == nums[last+1]) {
					last--;
					continue;
				}
				if(nums[first]+nums[last] == temp) {
					ArrayList<Integer> one = new ArrayList<Integer>();
					one.add(nums[i]);
					one.add(nums[first]);
					one.add(nums[last]);
					res.add(one);
					first++;
					last--;
				} else if(nums[first]+nums[last] < temp) {
					first++;
				} else {
					last--;
				}
			}
		}
		return res;
    }
}
