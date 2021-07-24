package leetcode;


public class Ques1893 {

	public static void main(String[] args) {

	}

	public boolean isCovered(int[][] ranges, int left, int right) {

		int[] dp = new int[right-left+1];
		int start = 0;
		int end = 0;
		for (int[] range : ranges) {
			start = range[0];
			if(start > right){
				continue;
			}
			end = range[1];
			if (end < left) {
				continue;
			}
			end = Math.min(end,right);
			for (int i = Math.max(start,left); i <= end ; i++) {

			}
		}

		return false;
	}

}
