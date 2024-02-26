package leetcode.second;

import java.util.*;


public class Ques128 {

	boolean[] visited; //是否访问过
	int[] lenArray; //大于等于此索引的数序列长度
	Map<Integer, Integer> map = new HashMap<>(); // 值到索引的映射

	public int longestConsecutive(int[] nums) {
		visited = new boolean[nums.length]; //是否访问过
		lenArray = new int[nums.length];

		for (int i = 0; i < lenArray.length; i++) {
			lenArray[i] = 1;
			map.put(nums[i], i);
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				res = Math.max(res, lenArray[i]);
				continue;
			}
			res = Math.max(res, getLen(nums, i));
		}
		return res;
	}


	public int getLen(int[] nums, int index) {
		if (visited[index]) {
			return lenArray[index];
		}
		int curLen = lenArray[index];
		if (map.containsKey(nums[index] + 1)) {
			curLen = Math.max(lenArray[index], getLen(nums, map.get(nums[index] + 1)) + 1);
		}
		lenArray[index] = curLen;
		visited[index] = true;
		return curLen;
	}

	// 官方题解不需要用到递归，空间更省，速度更快

	/**
	 * 思路，遍历每个元素，如果不存在自身-1的元素时，即最小的序列值，因此才在内层使用while循环获取最大长度，
	 * 如果存在自身-1，证明是非最小序列值，已经/将要被访问，无需例会直接跳过，所以所有元素只会被访问一次，O(N)复杂度
	 * @param nums
	 * @return
	 */
	public int longestConsecutive2(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}

		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}

}
