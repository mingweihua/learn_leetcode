package leetcode;

public class Ques3 {

	public static void main(String[] args) {
		int[] a1 = { 1, 3 };
		int[] a2 = { 3, 4 };
		new Ques3().findMedianSortedArrays(a1, a2);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int left = 0;
		int right = m;
		while (left < right) {
			int i = left + (right - left + 1) / 2;
			int j = (m + n + 1) / 2 - i;
			if (nums1[i - 1] > nums2[j]) {
				right = i - 1;
			} else {
				left = i;
			}
		}

		int i = left;
		int j = (m + n + 1) / 2 - i;

		int nums1_maxLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
		int nums1_minRight = i == m ? Integer.MAX_VALUE : nums1[i];
		int nums2_maxLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
		int nums2_minRight = j == n ? Integer.MAX_VALUE : nums2[j];

		int maxLeft = Math.max(nums1_maxLeft, nums2_maxLeft);
		int minRight = Math.min(nums1_minRight, nums2_minRight);

		if ((m + n) % 2 == 0) {
			return (maxLeft + minRight) / 2.0;
		} else {
			return maxLeft;
		}
		

	}
}
