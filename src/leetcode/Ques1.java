package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Ques1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 7, 11, 20 };
		int target = 9;
		System.out.println(twoSum(arr, target).toString());
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int component = target - nums[i];
			if (arrMap.containsKey(component)) {
				return new int[] {arrMap.get(component), i};
			}
			arrMap.put(nums[i], i);
		}
		throw new IllegalArgumentException("no solution");
	}
}
