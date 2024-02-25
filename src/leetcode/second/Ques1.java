package leetcode.second;

import java.util.*;
import java.util.stream.Collectors;

public class Ques1 {


	// 暴力解法
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
				}
			}
		}
		return res;
	}

	// 针对每个元素x, 是否可以对num处理，快速查询target-x值是否存在

	// hash方法处理
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> list;
			if (map.containsKey(nums[i])) {
				list = map.get(nums[i]);
			} else {
				list = new ArrayList<>();

			}
			list.add(i);
			map.put(nums[i], list);
		}

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (map.containsKey(target - x)) {
				ArrayList<Integer> list = map.get(target - x);
				for (int j : list) {
					if (j != i) {
						res[0] = i;
						res[1] = j;
						return res;
					}
				}
			}
		}

		return res;
	}

	// 官方解答
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
}
