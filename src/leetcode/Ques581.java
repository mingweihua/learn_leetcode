package leetcode;

import java.util.*;

public class Ques581 {

	public static void main(String[] args) {
		int[] nums = {2,6,4,1,8,10,9,15};
		System.out.println(new Ques581().findUnsortedSubarray3(nums));
	}


	public int findUnsortedSubarray(int[] nums) {
		if(nums.length <=1 ){
			return 0;
		}
		int left = 0;
		int right = nums.length-1;
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			min.add(nums[i]);
			max.add(nums[i]);
		}

		while(left<=right && nums[left] == min.peek()){
			left++;
			min.remove();
		}

		while(left<=right && nums[right] == max.peek()){
			right--;
			max.remove();
		}
		return right-left+1;
	}

	//官方解答，几种


	//排序。O(nlogn)
	public int findUnsortedSubarray2(int[] nums) {
		int[] arr = nums.clone();
		Arrays.sort(arr);
		int left = 0;
		int right = nums.length-1;
		while (left<=right && nums[left] == arr[left]){
			left++;
		}
		while (left<=right && nums[right] == arr[right]){
			right--;
		}
		return right-left+1;
	}

	//栈
	public int findUnsortedSubarray3(int[] nums) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		int left = nums.length-1;
		for (int i = 1; i < nums.length; i++) {
			if(list.isEmpty() || nums[list.peekLast()]<=nums[i]){
				list.add(i);
			} else {
				while (!list.isEmpty() && nums[list.peekLast()]>nums[i]){
					left = Math.min(left,list.removeLast());
				}
			}
		}

		list = new LinkedList<>();
		int right = 0;
		list.add(nums.length-1);
		for (int i = nums.length -1; i >= 0; i--) {
			if(list.isEmpty() || nums[list.peekLast()]>=nums[i]){
				list.add(i);
			} else {
				while (!list.isEmpty() && nums[list.peekLast()]<nums[i]){
					right = Math.max(right,list.removeLast());
				}
			}
		}
		if(left>right){
			return 0;
		}
		return right-left+1;
	}


	//O(n),空间复杂度为O(1)；

	public int findUnsortedSubarray4(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] < nums[i - 1]) {
				flag = true;
			}

			if (flag) {
				min = Math.min(min, nums[i]);
			}
		}
		flag = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) {
				flag = true;
			}
			if (flag) {
				max = Math.max(max, nums[i]);
			}
		}
		int l, r;
		for (l = 0; l < nums.length; l++) {
			if (min < nums[l]) {
				break;
			}
		}
		for (r = nums.length - 1; r >= 0; r--) {
			if (max > nums[r]) {
				break;
			}
		}
		return r - l < 0 ? 0 : r - l + 1;
	}
}
