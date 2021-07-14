package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ques1818 {

	public static void main(String[] args) {
		int[] nums1 = {53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46};
		int[] nums2 = {39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79};
		System.out.println(new Ques1818().minAbsoluteSumDiff(nums1,nums2));
	}

	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		final int MOD = 1000000007;
		int sum = 0;
		int max = 0;
		int temp = 0;
		int[] s = Arrays.copyOf(nums1,nums1.length);
		Arrays.sort(s);

		for (int i = 0; i < nums1.length; i++) {
			if(i == 46){
				System.out.println("");
			}
			temp = Math.abs(nums1[i] - nums2[i]);
			sum = (sum + temp)%MOD;
			max = Math.max(max,temp - binarySearch(s,nums2[i]));

			//验证
			int j = binarySearch2(s,nums2[i]);
			if (j <  nums2.length) {
				if(temp - (s[j] - nums2[i]) > max){
					System.out.println(i);
					System.out.println("111");

				}
			}
			if (j > 0) {
				if(temp - (nums2[i] - s[j - 1]) > max){
					System.out.println(i);
					System.out.println("222");
				}
			}

		}
		return (sum - max + MOD) % MOD;
	}


	public int binarySearch(int[] s, int target){
		//通过二分查找大于或等于
		int left = 0;
		int right = s.length-1;
		int mid = 0;
		while (left < right){
			mid = left + ((right - left )>>1);
			if(s[mid] == target){
				return 0;
			} else if(s[mid] > target ){
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		int temp = Math.abs(s[left]-target);
		int temp2 = Math.abs(s[left-1]-target);

		return Math.min(temp,temp2);
	}


	public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
		final int MOD = 1000000007;
		int sum = 0;
		int max = 0;
		int temp = 0;
		int[] s = Arrays.copyOf(nums1,nums1.length);
		Arrays.sort(s);

		for (int i = 0; i < nums2.length; i++) {

			temp = Math.abs(nums1[i] - nums2[i]);
			sum = (sum + temp)%MOD;
			int j = binarySearch(s,nums2[i]);

			if (j <  nums2.length) {
				max = Math.max(max, temp - (s[j] - nums2[i]));
			}
			if (j > 0) {
				max = Math.max(max, temp - (nums2[i] - s[j - 1]));
			}

		}
		return (sum - max + MOD) % MOD;
	}


	public int binarySearch2(int[] rec, int target) {
		int low = 0, high = rec.length - 1;
		if (rec[high] < target) {
			return high + 1;
		}
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (rec[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
