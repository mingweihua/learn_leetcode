package leetcode;

import java.util.HashSet;
import java.util.Stack;

public class Ques457 {
	
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,2};
		System.out.println(new Ques457().circularArrayLoop(nums));
	}

	public boolean circularArrayLoop(int[] nums) {
		boolean[] check = new boolean[nums.length];
		HashSet<Integer> set;
		int direct = 1;
		for (int i = 0; i < nums.length; i++) {
			set = new HashSet<>();
			if(!check[i]){
				direct = nums[i] > 0?1:-1;
				int cur = i;
				while (!check[cur] && !set.contains(cur)){
					if(nums[cur]*direct < 0){
						break;
					}
					set.add(cur);
					cur = (cur + nums[cur] + nums.length * 1000) % nums.length;
				}
				if(check[cur] || nums[cur]*direct < 0){
					for (int j : set) {
						check[j] = true;
					}
					continue;
				}
				int k = 1;
				int end = cur;
				cur = (cur + nums[cur] + nums.length * 1000) % nums.length;
				while (cur!= end){
					k++;
					cur = (cur + nums[cur] + nums.length * 1000) % nums.length;
				}
				if(k==1){
					for (int j : set) {
						check[j] = true;
					}
					continue;
				}

				return true;

			}
		}
		return false;
	}
}
