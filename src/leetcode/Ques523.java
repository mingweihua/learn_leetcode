package leetcode;

import java.util.HashMap;

public class Ques523 {

	public static void main(String[] args) {
		
	}
	
	public int findMaxLength(int[] nums) {
		int res = 0;
		int[] pre = new int[nums.length+1];
		pre[0] = 0;
		for (int i = 1; i < pre.length; i++) {
			pre[i] = pre[i-1] + (nums[i-1] == 1?1:-1);
		}
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		map.put(0, 0);
		for (int i = 1 ; i < pre.length; i++) {
			res = Math.max(res, i - map.getOrDefault(pre[i], i));
			map.put(pre[i], map.getOrDefault(pre[i], i));
		}
		return res;
    }
	
	//优化一下，一遍遍历就完事
	public int findMaxLength2(int[] nums) {
		int res = 0;
		int pre = 0;
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		map.put(0, -1);
		for (int i = 0 ; i < nums.length; i++) {
			pre += (nums[i] == 1?1:-1);
			res = Math.max(res, i - map.getOrDefault(pre, i));
			map.put(pre, map.getOrDefault(pre, i));
		}
		return res;
    }
	
	//优化一下，map.get其实挺耗费时间的，当然时间复杂度一样的
	public int findMaxLength3(int[] nums) {
		int res = 0;
		int pre = 0;
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		map.put(0, -1);
		int temp = 0;
		for (int i = 0 ; i < nums.length; i++) {
			pre += (nums[i] == 1?1:-1);
			if(map.containsKey(pre)) {
				temp = map.get(pre);
				res = Math.max(res, i - temp);
			} else {
				map.put(pre, i);
			}
		}
		return res;
    }
}
