package leetcode;

public class Ques323 {

	public static void main(String[] args) {

	}


	public int countComponents(int n, int[][] edges) {

		boolean[][] dp = new boolean[n][n];
		boolean[] check = new boolean[n];
		for (int[] edge : edges) {
			dp[edge[0]][edge[1]] = true;
			dp[edge[1]][edge[0]] = true;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			if(check[i]){
				continue;
			}
			res++;
			checkFun(dp,check,i);
		}
		return res;
	}

	public void checkFun(boolean[][] dp , boolean[] check,int cur){
		if(check[cur]){
			return;
		}
		check[cur] = true;
		for (int i = 0; i < dp[cur].length; i++) {
			if(dp[cur][i] && !check[i]){
				checkFun(dp,check,i);
			}
		}
	}

}
