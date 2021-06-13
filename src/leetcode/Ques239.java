package leetcode;

import java.util.LinkedList;

public class Ques239 {

	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		System.out.println(new Ques239().maxSlidingWindow(arr, 3));
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || nums.length < k) {
			return null;
		}
		
		int[] res = new int[nums.length-k+1];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]) {
				queue.pollLast();
			}
			queue.addLast(i);
			while(!queue.isEmpty() && queue.peekFirst()<=i-k) {
				queue.pollFirst();
			}
			if(i-k+1>=0) {
				res[i-k+1] = nums[queue.peekFirst()];
			}
		}
 		
		return res;	
    }
}
