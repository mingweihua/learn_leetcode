package leetcode.second;

import java.util.*;


public class Ques128 {

	boolean[] visited; //是否访问过
	int[] lenArray; //大于等于此索引的数序列长度

	Map<Integer, Integer> map = new HashMap<>(); // 值到索引的映射

	int res = 0;

	public int longestConsecutive(int[] nums) {
		visited = new boolean[nums.length]; //是否访问过
		lenArray = new int[nums.length];

		for (int i = 0; i < lenArray.length; i++) {
			lenArray[i] = 1;
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}

			// todo
		}
		return res;
	}


	public int getLen(int[] nums, int index) {
		if (visited[index]) {
			return lenArray[index];
		}
		if (map.containsKey(nums[index] + 1)) {
			lenArray[index] = Math.max(lenArray[index], getLen(nums, map.get(nums[index] + 1)) + 1);
		}
		visited[index] = true;
		return lenArray[index];
	}
}
