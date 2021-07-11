package leetcode;

import java.util.Arrays;

public class Ques274 {

	public static void main(String[] args) {

		int[] arr = {3,0,6,1,5};
		System.out.println(new Ques274().hIndex(arr));
	}

	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int res = 0;
		for (int i = citations.length-1; i >= 1; i--) {
			if(citations.length - i <= citations[i] && citations[i-1] <=  citations.length - i){
				res = Math.max(res,citations.length - i);
			}
		}
		if(citations.length <= citations[0]){
			return citations.length;
		}
		return res;
	}
}
