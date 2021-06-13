package leetcode;

import java.util.HashMap;

public class Ques560 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,4,5,1,-5,-4,6};
		System.out.println(new Ques560().subarraySum(nums, 6));
	}
	
	
	
	public int subarraySum(int[] nums, int k) {
		if(nums.length==0) {
			return 0;
		}
		int num = 0;
		int[] pre = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			pre[i+1] = pre[i] + nums[i];
		}
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		for (int i = 0; i < pre.length; i++) {
			num += map.getOrDefault(pre[i]-k, 0);
			map.put(pre[i], map.getOrDefault(pre[i], 0)+1);
		}
		return num;
    }
	
	//优化，只要一次循环
	public int subarraySum2(int[] nums, int k) {
		if(nums.length==0) {
			return 0;
		}
		int num = 0;
		int[] pre = new int[nums.length+1];
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		map.put(0, 1);
		for (int i = 1; i < pre.length; i++) {
			pre[i] = pre[i-1] + nums[i-1];
			num += map.getOrDefault(pre[i]-k, 0);
			map.put(pre[i], map.getOrDefault(pre[i], 0)+1);
		}
		return num;
    }
}
