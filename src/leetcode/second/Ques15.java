package leetcode.second;


import java.util.*;
import java.util.stream.Collectors;

public class Ques15 {

	// 超时
	List<List<Integer>> res = new ArrayList<>();

	// 官方题解 双指针解法
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			twoSum(-nums[i], nums, i+1, nums.length - 1);
			while (i < nums.length - 2 && nums[i] == nums[i+1]) {
				i++;
			}
		}
		return res;
	}

	public void twoSum(int target, int[] nums, int left, int right) {
		int start = left;
		int end = right;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				List<Integer> list = new ArrayList<>();
				list.add(-target);
				list.add(nums[start]);
				list.add(nums[end]);
				res.add(list);
			} else if (nums[start] + nums[end] > target){
				end --;
				continue;
			} else {
				start++;
				continue;
			}

			while (start < end && nums[start] == nums[start + 1]) {
				start++;
			}
			start++;

			while (start < end && nums[end] == nums[end - 1]) {
				end--;
			}
			end--;
		}
	}
}
