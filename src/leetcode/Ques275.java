package leetcode;

import java.util.Arrays;

public class Ques275 {

	public static void main(String[] args) {

		int[] arr = {3,0,6,1,5};
		System.out.println(new Ques275().hIndex(arr));
	}

	public int hIndex(int[] citations) {
		if(citations.length <= citations[0]){
			return citations.length;
		}
		for (int i = 1; i < citations.length; i++) {
			if(citations.length - i <= citations[i] && citations[i-1] <= citations.length-i){
				return citations.length - i;
			}
		}
		return 0;
	}

	//二分查找
	public int hIndex2(int[] citations) {
		if(citations.length <= citations[0]){
			return citations.length;
		}
		int left = 0, right = citations.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (citations[mid] >= citations.length - mid ) {
				right = mid-1;
			} else {
				left = mid + 1;
			}
		}
		return citations.length - left;
	}
}
