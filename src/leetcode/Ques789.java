package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Ques789 {

	public static void main(String[] args) {
		int[][] ghosts = {{1,0},{0,3}};
		int[] target = {0,1};
		System.out.println(new Ques789().escapeGhosts(ghosts,target));
	}

	//直接超时，不需要真的通过dfs遍历所有可能出来，看下面的官方答案
	int[][] dp;
	int[][] dp2;
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int x_min = Integer.MAX_VALUE;
		int x_max = Integer.MIN_VALUE;
		int y_min = Integer.MAX_VALUE;
		int y_max = Integer.MIN_VALUE;
		for (int[] ghost : ghosts) {
			if(ghost[0] == target[0] && ghost[1] == target[1]){
				return false;
			}
			x_max = Math.max(x_max,ghost[0]);
			x_min = Math.min(x_min,ghost[0]);
			y_max = Math.max(y_max,ghost[1]);
			y_min = Math.min(y_min,ghost[1]);
		}
		x_max = Math.max(x_max,target[0]);
		x_min = Math.min(x_min,target[0]);
		y_max = Math.max(y_max,target[1]);
		y_min = Math.min(y_min,target[1]);
		x_max = Math.max(x_max,0);
		x_min = Math.min(x_min,0);
		y_max = Math.max(y_max,0);
		y_min = Math.min(y_min,0);
		if(target[0] == 0 && target[1] == 0){
			return true;
		}
		int n = x_max - x_min + 1;
		int m = y_max - y_min + 1;
		dp = new int[n][m];
		dp2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i],Integer.MAX_VALUE/2);
			Arrays.fill(dp2[i],Integer.MAX_VALUE/2);
		}
		for (int[] ghost : ghosts) {
			int x = ghost[0];
			int y = ghost[1];
			dfs_ghost(x-x_min,y-y_min,0,n,m,target[0]-x_min,target[1]-x_min);
		}
		dfs(0-x_min,0-y_min,0,n,m,target[0]-x_min,target[1]-x_min);
		return dp2[target[0]-x_min][target[1]-y_min] < dp[target[0]-x_min][target[1]-y_min];
	}


	public void dfs_ghost(int x,int y,int step,int n,int m,int target_x,int target_y){
		if(x<0 || x>=n || y<0 || y>= m){
			return;
		}
		if(step >= dp[x][y]){
			return;
		}
		dp[x][y] = Math.min(dp[x][y],step);
		if(x == target_x && y == target_y){
			return;
		}
		dfs_ghost(x+1,y,step+1,n,m,target_x,target_y);
		dfs_ghost(x-1,y,step+1,n,m,target_x,target_y);
		dfs_ghost(x,y+1,step+1,n,m,target_x,target_y);
		dfs_ghost(x,y-1,step+1,n,m,target_x,target_y);
	}

	public void dfs(int x,int y,int step,int n,int m,int target_x,int target_y){
		if(x<0 || x>=n || y<0 || y>= m){
			return;
		}
		if(step >= dp2[x][y]){
			return;
		}
		dp2[x][y] = Math.min(dp2[x][y],step);
		if(dp2[x][y] >= dp[x][y]){
			return;
		}
		if(x == target_x && y == target_y){
			return;
		}
		dfs(x+1,y,step+1,n,m,target_x,target_y);
		dfs(x-1,y,step+1,n,m,target_x,target_y);
		dfs(x,y+1,step+1,n,m,target_x,target_y);
		dfs(x,y-1,step+1,n,m,target_x,target_y);
	}

	/*
		为了逃脱阻碍者，玩家应按照最短路径向目的地移动。阻碍者为了抓住玩家，也会按照最短路径向目的地移动。由于每次移动为向四个方向之一移动一个单位，
		因此对于玩家和阻碍者而言，到达目的地的最短路径的距离为当前所在位置和目的地的曼哈顿距离。

		用 {dist}(A, B) 表示 A点和 B 点的曼哈顿距离，曼哈顿距离的计算方法如下：

			{dist}(A, B) = | x_A - x_B | + | y_A - y_B |

		简单理解就是
			只要初始位置距离终点比小怪更近，小怪就不可能在你之前到达你初始位置到终点的最近路径上，反之小鬼可以直接去终点蹲你。
	 */
	public boolean escapeGhosts2(int[][] ghosts, int[] target) {
		ArrayList<Integer> queue = new ArrayList<>();
		for (int[] ghost : ghosts) {
			int temp = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
			queue.add(temp);
		}
		int comp = Math.abs(0 - target[0]) + Math.abs(0 - target[1]);
		for (int i = 0; i < queue.size(); i++) {
			if(comp >= queue.get(i)){
				return false;
			}
		}
		return true;
	}
}
