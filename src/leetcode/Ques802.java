package leetcode;


import java.util.*;

public class Ques802 {

	public static void main(String[] args) {

	}
	int[] check;
	public List<Integer> eventualSafeNodes(int[][] graph) {
		ArrayList<Integer> list = new ArrayList<>();
		check = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if(check[i] == 0){
				if(dfs(graph,i)){
					list.add(i);
				}
			} else if(check[i] == 2){
				list.add(i);
			}
		}
		return list;
	}

	public boolean dfs(int[][] graph,int cur) {
		if(check[cur] == 1){
			return false;
		}
		if(graph[cur].length == 0 || check[cur] == 2){
			check[cur] = 2;
			return true;
		}

		check[cur] = 1;

		boolean flag = true;
		for (int i = 0; i < graph[cur].length; i++) {
			int temp = graph[cur][i];
			if((!flag) || check[temp] == 1){
				return false;
			}
			if(check[temp] == 2){
				continue;
			}
			if(check[temp] == 0){
				flag = flag && dfs(graph,temp);
			}
		}

		if(flag){
			check[cur] = 2;
			return true;
		}
		return false;
	}

	//官方更简单的解法，思路一样
	public List<Integer> eventualSafeNodes2(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			if (safe(graph, color, i)) {
				ans.add(i);
			}
		}
		return ans;
	}

	public boolean safe(int[][] graph, int[] color, int x) {
		if (color[x] > 0) {
			return color[x] == 2;
		}
		color[x] = 1;
		for (int y : graph[x]) {
			if (!safe(graph, color, y)) {
				return false;
			}
		}
		color[x] = 2;
		return true;
	}


}
