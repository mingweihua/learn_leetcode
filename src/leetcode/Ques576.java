package leetcode;


import java.util.LinkedList;

public class Ques576 {

	public static void main(String[] args) {
		System.out.println(new Ques576().findPaths(10,10,11,5,5));
	}

	//使用广度优先搜索，答案是没问题，但是会超时
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int mod = 1000000007;
		if(maxMove<=0){
			return 0;
		}
		int res = 0;
		int step = 0;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startRow,startColumn});
		while (step<=maxMove){
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.remove();

				if(cur[0]<0 || cur[0] >= m){
					res = (res+1)%mod;
					continue;
				}

				if(cur[1]<0 || cur[1] >= n){
					res = (res+1)%mod;
					continue;
				}

				//上移
				queue.add(new int[]{cur[0]-1,cur[1]});
				//下移
				queue.add(new int[]{cur[0]+1,cur[1]});
				//右移
				queue.add(new int[]{cur[0],cur[1]+1});
				//左移
				queue.add(new int[]{cur[0],cur[1]-1});
			}
		}
		return res;
	}

	//动态规划方法

	/*
		即使知道使用动态规划，不知道怎么用，看了答案才会


		动态规划的状态由移动次数、行和列决定，定义 {dp}[i][j][k]表示球移动 i 次之后位于坐标 (j, k)的路径数量。

	 */
	public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
		int mod = 1000000007;
		if(maxMove<=0){
			return 0;
		}
		int res = 0;
		int[][][] dp = new int[maxMove+1][m][n];
		dp[0][startRow][startColumn] = 1;
		for (int i = 1; i <= maxMove ; i++) {
			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++) {
					int count = dp[i-1][x][y];

					/*
					  上，下，左，右
					 */
					if(x-1<0){
						res = (res + count)%mod;
					} else {
						dp[i][x-1][y] = (dp[i][x-1][y]+count)%mod;
					}

					if(x+1>=m){
						res = (res + count)%mod;
					} else {
						dp[i][x+1][y] = (dp[i][x+1][y]+count)%mod;
					}

					if(y-1<0){
						res = (res + count)%mod;
					} else {
						dp[i][x][y-1] = (dp[i][x][y-1]+count)%mod;
					}

					if(y+1>=n){
						res = (res + count)%mod;
					} else {
						dp[i][x][y+1] = (dp[i][x][y+1]+count)%mod;
					}
				}
			}
		}
		return res;
	}
}
