package leetcode;


public class Ques1893 {

	public static void main(String[] args) {

	}

	public boolean isCovered(int[][] ranges, int left, int right) {

		boolean[] dp = new boolean[right-left+1];
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
				if(!dp[i - left]){
					dp[i - left] = true;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			if(!dp[i]){
				return false;
			}
		}
		return true;
	}

}
