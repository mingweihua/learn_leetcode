package leetcode;


import java.util.Arrays;

public class Ques611 {

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};
		System.out.println(new Ques611().triangleNumber(nums));
	}

	/*
	611. 有效三角形的个数
	 */

	//排序+二分，时间复杂度为O(n*nlogn); 说白了就是二分让一个n转换成logn
	public int triangleNumber(int[] nums) {
		if(nums.length<3){
			return 0;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;
		int one = 0;
		while (one < n && nums[one] == 0){
			one++;
		}
		if(n - one < 3){
			return 0;
		}
		for (int i = one; i <= n-3; i++) {
			for (int j = i+1; j <= n-2 ; j++) {
				int target = nums[i]+nums[j];
				if(j+1 == n-1){
					if(nums[n-1]<target){
						res++;
					}
					continue;
				}
				if(nums[n-1]<target){
					res += (n-j-1);
					continue;
				}
				int left = j+1;
				int right = n-1;
				int mid = 0;
				while (left<right) {
					mid = left + ((right - left)>>1);
					if(nums[mid]<target){
						left = mid+1;
					} else {
						right = mid;
					}
				}
				res += (left-j-1);
			}
		}
		return res;
	}

	//排序+双指针，时间复杂度为O(n*n);
	/*
		根据题目的特点
		思路与算法

		固定i, j增大，nums[i]+nums[j]也是递增的，此时最大的k也是递增的，因此不需要再次二分查找k，直接递增k即可
		也就是双指针，所以j和k是同时递增的，算一个n，最后复杂度是n*n

		双指针运用得好其实能把很多n*n问题转换成n得问题

	 */
	public int triangleNumber2(int[] nums) {
		if(nums.length<3){
			return 0;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;
		int one = 0;
		while (one < n && nums[one] == 0){
			one++;
		}
		if(n - one < 3){
			return 0;
		}
		for (int i = one; i <= n-3; i++) {
			int k = i;
			for (int j = i+1; j <= n-2 ; j++) {
				while (k<=n-1 && nums[k] < nums[i]+nums[j]){
					k++;
				}
				res += Math.max(k-j-1,0);
			}
		}
		return res;
	}
}
