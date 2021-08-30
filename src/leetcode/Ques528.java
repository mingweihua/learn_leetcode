package leetcode;

import java.util.Random;

public class Ques528 {

	public static void main(String[] args) {

	}


	//超出内存限制
	class Solution {

		int[] dp;
		Random random;
		public Solution(int[] w) {
			int sum = 0;
			for (int i = 0; i < w.length; i++) {
				sum += w[i];
			}
			dp = new int[sum];
			int cur = -1;
			for (int i = 0; i < w.length; i++) {
				for (int j = 0; j < w[i]; j++) {
					dp[++cur] = i;
				}
			}
			random = new Random();
		}

		public int pickIndex() {
			int index = random.nextInt(dp.length+1);
			return dp[index];
		}
	}


	//实际没必要把这些数都存起来
	class Solution2 {

		Random random;
		int[] pre;
		public Solution2(int[] w) {
			random = new Random();
			pre = new int[w.length];
			pre[0] = w[0];
			for (int i = 1; i < w.length; i++) {
				pre[i] = pre[i-1] +  w[i];
			}


		}

		public int pickIndex() {
			int left = 0;
			int right = pre.length-1;
			int target = random.nextInt(pre[right])+1;
			int mid = 0;
			while (left<right){
				mid = left + ((right - left)>>1);
				if(pre[mid]>=target){
					right = mid;
				} else {
					left = mid+1;
				}
			}

			return left;
		}
	}

}
