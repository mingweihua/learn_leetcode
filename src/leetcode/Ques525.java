package leetcode;

import java.util.HashMap;

public class Ques525 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int k = 5;
		System.out.println(new Ques525().checkSubarraySum2(nums, k));
	}
	
	//超出时间限制了
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums.length<2) {
			return false;
		}
		int sum = nums[0] + nums[1];
		if(sum % k == 0) {
			return true;
		}
		int preSum = 0;
		for (int i = 2; i < nums.length; i++) {
			sum += nums[i];
			if(sum %k == 0) {
				return true;
			}
			preSum = sum;
			for(int j=0;j<i-1;j++) {
				preSum -= nums[j];
				if(preSum %k == 0) {
					return true;
				}
			}
		}
		
		return false;
    }
	
	
	//前缀和与hash表实现，关键点在于pre[i] - pre[j]若是k的倍数，则他们除以k的余数一定相同
	public boolean checkSubarraySum2(int[] nums, int k) {
		if(nums.length<2) {
			return false;
		}
		int[] pre = new int[nums.length+1];
		pre[0] = 0;
		for (int i = 1; i < pre.length; i++) {
			pre[i] = pre[i-1] + nums[i-1];
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		int temp = 0;
		int mod = 0;
		for (int i = 1; i < pre.length; i++) {
			mod = pre[i] % k;
			temp = map.getOrDefault(mod, i);
			if(i - temp>1) {
				return true;
			}
			map.put(mod, map.getOrDefault(mod, i));	
		}
		return false;
    }
	
	//优化上述算法空间复杂度
	public boolean checkSubarraySum3(int[] nums, int k) {
		if(nums.length<2) {
			return false;
		}
		int pre = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int temp = 0;
		int mod = 0;
		for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			mod = pre % k;
			temp = map.getOrDefault(mod, i);
			if(i - temp>1) {
				return true;
			}
			map.put(mod, map.getOrDefault(mod, i));	
		}
		return false;
    }
}
