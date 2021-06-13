package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Ques1035 {

	public static void main(String[] args) {
		int[] nums1 = {15,14,1,7,15,1,12,18,9,15,1,20,18,15,16,18,11,8,11,18,11,11,17,
				20,16,20,15,15,9,18,16,4,16,1,13,10,10,20,4,18,17,3,8,1,8,19,14,10,10,12};
		int[] nums2 = {12,8,17,4,2,18,16,10,11,12,7,1,8,16,4,14,12,18,18,19,19,1,11,18,1,
				6,12,17,6,19,10,5,11,16,6,17,12,1,9,3,19,2,18,18,2,4,11,11,14,9,20,19,2,20
				,9,15,8,7,8,6,19,12,4,11,18,18,1,6,9,17,13,19,5,4,14,9,11,15,2,5,4,1,10,11,
				6,4,9,7,11,7,3,8,11,12,4,19,12,17,14,18};
		System.out.println(new Ques1035().maxUncrossedLines(nums1, nums2));
	}
	
	//O(2^n)超出时间限制
	HashMap<Integer, PriorityQueue<Integer>> minMap = new HashMap<Integer, PriorityQueue<Integer>>();
	int res = 0;
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
//		for (int i = 0; i < nums1.length; i++) {
//			minMap.put(nums1[i], new PriorityQueue<Integer>());
//		}
//		PriorityQueue<Integer> queue = null;
//		for (int i = 0; i < nums2.length; i++) {
//			if(minMap.containsKey(nums2[i])) {
//				queue = minMap.get(nums2[i]);
//				queue.add(i);
//			}
//		}
//		for (int i = 0; i < nums1.length; i++) {
//			if(minMap.containsKey(nums1[i]) && minMap.get(nums1[i]).size() == 0) {
//				minMap.remove(nums1[i]);
//			}
//		}
		dfs(nums1,nums2,0,0,0);
		return res;
    }
	
	
	public void dfs(int[] nums1, int[] nums2, int index1, int index2, int size) {
		if(index1 >= nums1.length ||  index2 >= nums2.length) {
			res = Math.max(res, size);
			return;
		}
		int temp = index2;
		while(temp<nums2.length) {
			if(nums1[index1] == nums2[temp]) {
                dfs(nums1,nums2,index1+1,temp+1,size+1);
				break;
			}
			temp++;
		}
		dfs(nums1,nums2,index1+1,index2,size);
		return;
    }
	
	public void dfs2(int[] nums1, int[] nums2, int index1, int index2, int size) {
		if(index1 >= nums1.length ||  index2 >= nums2.length) {
			res = Math.max(res, size);
			return;
		}
		if(minMap.containsKey(nums1[index1])) {
			PriorityQueue<Integer> queue = minMap.get(nums1[index1]);
			int temp;
			while(!queue.isEmpty()) {
				temp = queue.remove();
				if(temp>=index2) {
					dfs2(nums1,nums2,index1+1,temp+1,size+1);
					break;
				}
			}
			if(queue.isEmpty()) {
				minMap.remove(nums1[index1]);
			}
		}
		dfs2(nums1,nums2,index1+1,index2,size);
		return;
    }
	
	
	public int maxUncrossedLines2(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length+1][nums2.length+1];
		for (int i = 0; i <= nums1.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= nums2.length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[nums1.length][nums2.length];
    }
}
