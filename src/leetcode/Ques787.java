package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Ques787 {

	public static void main(String[] args) {
		int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

	}


	//看了答案才会的，使用动态规划方法
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		final int INF = 10000 * 101 + 1;
		int[][] f = new int[k + 2][n];
		for (int i = 0; i < k + 2; ++i) {
			Arrays.fill(f[i], INF);
		}
		f[0][src] = 0;
		for (int t = 1; t <= k + 1; ++t) {
			for (int[] flight : flights) {
				int j = flight[0], i = flight[1], cost = flight[2];
				f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
			}
		}
		int ans = INF;
		for (int t = 1; t <= k + 1; ++t) {
			ans = Math.min(ans, f[t][dst]);
		}
		return ans == INF ? -1 : ans;

	}

}
