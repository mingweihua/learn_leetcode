package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Ques117 {

	public static void main(String[] args) {

	}

	public int singleNumber(int[] nums) {
		if(nums.length==1) {
			return nums[0];
		}
		HashSet<Integer> one = new HashSet<Integer>();
		HashSet<Integer> repeat = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(repeat.contains(nums[i])) {
				continue;
			}
			if(one.contains(nums[i])) {
				one.remove(nums[i]);
				repeat.add(nums[i]);
			} else {
				one.add(nums[i]);
			}
		}
		for(Integer ele : one) {
			return ele;
		}
		return 0; 
    }
	
	public int singleNumber2(int[] nums) {
		if(nums.length==1) {
			return nums[0];
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		for(Integer key : map.keySet()) {
			if(map.get(key)==1) {
				return key;
			}
		}
		return -1;
    }
}
