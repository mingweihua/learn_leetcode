package leetcode.second;


import java.util.*;

public class Ques11 {

	// 看题解才会
	// 一般要找两个边位置，即移动左右位置，用左右指针
	// 难点 ： 如何恰当移动
	// 思考 ： 相同情况，越远越好。容积受限于最短边
	public int maxArea(int[] height) {
		if (height.length <= 1) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int res = 0;
		while (left < right) {
			if (height[left] <= height[right]) {
				res = Math.max(res, (right - left) * height[left]);
				left++;
			} else {
				res = Math.max(res, (right - left) * height[right]);
				right--;
			}
		}
		return res;
	}


}
