package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques797 {

	public static void main(String[] args) {

	}


	List<List<Integer>> res;
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		res = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		pre.add(0);
		dfs(graph,0,graph.length-1,pre);
		return res;
	}

	public void dfs(int[][] graph,int cur,int target,List<Integer> pre){
		if(cur == target){
			res.add(new ArrayList<>(pre));
			return;
		}
		for (int i = 0; i < graph[cur].length; i++) {
			pre.add(graph[cur][i]);
			dfs(graph,graph[cur][i],target,pre);
			pre.remove(pre.size()-1);
		}
	}

}
