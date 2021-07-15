package leetcode;

import java.util.Arrays;

public class Ques1846 {

	public static void main(String[] args) {

	}

	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		arr[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			if(arr[i]-arr[i-1]>1){
				arr[i] = arr[i-1] + 1;
			}
		}


		return arr[arr.length-1];
	}

	//方法二：计数排序 + 贪心(leetcode)
	public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
		int[] dp = new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > arr.length){
				dp[arr.length]++;
			} else {
				dp[arr[i]]++;
			}
		}

		int miss = 0;
		for (int i = 1; i < dp.length; i++) {
			if(dp[i]>0){
				if(dp[i] - miss > 0){
					miss = 0;
				} else {
					miss  = miss -dp[i] + 1;
				}
			} else {
				miss++;
			}
		}


		return arr.length - miss;
	}
}
