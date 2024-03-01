package leetcode.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Ques283 {


	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <=1) {
			return;
		}
		int p0Left = 0;
		int cur = 0;
		while (cur < nums.length) {
			if (nums[cur] != 0) {
				if (p0Left != cur) {
					int tmp = nums[p0Left];
					nums[p0Left] = nums[cur];
					nums[cur] = tmp;
				}
				p0Left++;
			}
			cur++;
		}
	}

}
