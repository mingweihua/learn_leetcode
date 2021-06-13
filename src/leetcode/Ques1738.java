package leetcode;

import java.util.PriorityQueue;

public class Ques1738 {

	public static void main(String[] args) {
		int[][] matrix = {{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}};
		int k = 2;
		System.out.println(new Ques1738().kthLargestValue(matrix, k));
	}

	public int kthLargestValue(int[][] matrix, int k) {
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		int[] dp = new int[matrix[0].length];
		dp[0] = matrix[0][0];
		minQ.add(dp[0]);
		for(int j = 1; j < matrix[0].length; j++) {
			dp[j] =  matrix[0][j] ^ dp[j-1];
			minQ.add(dp[j]);
			if(minQ.size()==k+1) {
				minQ.remove();
			}
		}
		int pre = 0;
		int cur = 0;
		for (int i = 1; i < matrix.length; i++) {
			pre = dp[0];
			dp[0] = dp[0] ^ matrix[i][0];
			minQ.add(dp[0]);
			if(minQ.size()==k+1) {
				minQ.remove();
			}
			for (int j = 1; j < matrix.length; j++) {
				cur = dp[j];
				dp[j] = cur ^ pre ^ dp[j-1] ^ matrix[i][j];
				minQ.add(dp[j]);
				if(minQ.size()==k+1) {
					minQ.remove();
				}
				pre = cur;
			}
		}
		return minQ.remove();
    }

}
