package leetcode.second;


import java.util.*;

public class Ques560 {

	// 和为k的子数组，需要看了标签才知道怎么做
	public int subarraySum(int[] nums, int k) {
		int[] preArr = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				preArr[i] = preArr[i-1] + nums[i-1];
			}
			int preSum = preArr[i];
			map.put(preArr[i], map.getOrDefault(preArr[i], 0) + 1);

			int cur = nums[i];
			res += map.getOrDefault(cur + preSum - k, 0);
		}
		return res;
	}

	// 再省空间
	public int subarraySum2(int[] nums, int k) {
		//int[] preArr = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		int res = 0;
		int preSum = 0;
		int prePreSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				preSum = prePreSum + nums[i-1];
			}

			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
			int cur = nums[i];
			res += map.getOrDefault(cur + preSum - k, 0);
			prePreSum = preSum;
		}
		return res;
	}

	// 官方解，pre[i]=pre[i−1]+nums[i]
	// 因此答案是  pre[i]−pre[j−1]==k 代表 j到i的和
	public int subarraySum3(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		map.put(0, 1);
		int res = 0;
		int preSum = 0;
		for (int i = 0; i < nums.length; i++) {
			preSum += nums[i];
			res += map.getOrDefault( preSum - k, 0);
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}
		return res;
	}
}
