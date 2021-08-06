package leetcode;

import java.util.LinkedList;

public class Ques847 {

	public static void main(String[] args) {
		int[][] graph = {{1,4},{0,3,10},{3},{1,2,6,7},{0,5},{4},{3},{3},{10},{10},{1,9,8}};
		System.out.println(new Ques847().shortestPathLength2(graph));
	}


	//自己写的，超时了
	public int shortestPathLength(int[][] graph) {
		int res = Integer.MAX_VALUE;
		int moved = 1;
		int check = (1 << graph.length) - 1;
		for (int i = 0; i < graph.length; i++) {
			res = Math.min(res,bfs(graph, i,(moved<<i),check));
		}
		return res;
	}

	public int bfs(int[][] graph, int cur,int moved,int check) {
		int[] start = new int[4];
		//上个节点
		start[0] = -1;
		//当前节点
		start[1] = cur;
		//已走过点
		start[2] = moved;
		//路径
		start[3] = 0;

		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()){
			int[] ele = queue.removeFirst();
			if((ele[2] ^ check) == 0){
				return ele[3];
			}
			int[] nexts = graph[ele[1]];
			for (int next : nexts) {
				int temp = (1<<next);
				if((temp & ele[2]) == 0){
					int[] nextEle = new int[4];
					nextEle[0] = ele[1];
					nextEle[1] = next;
					nextEle[2] = (temp ^ ele[2]);
					nextEle[3] = ele[3]+1;
					queue.add(nextEle);
				} else {
					int[] nextEle = new int[4];
					nextEle[0] = ele[1];
					nextEle[1] = next;
					nextEle[2] = ele[2];
					nextEle[3] = ele[3]+1;
					queue.add(nextEle);
				}
			}

		}
		return 0;
	}


	public int shortestPathLength2(int[][] graph) {
		int n = graph.length;
		LinkedList<int[]> queue = new LinkedList<>();
		int res = 0;
		int check = (1 << graph.length) - 1;
		boolean[][] seen = new boolean[n][1 << n];
		for (int i = 0; i < graph.length; i++) {
			queue.add(new int[]{i,1<<i,0});
			seen[i][1<<i] = true;
		}

		while (!queue.isEmpty()) {
			int[] ele = queue.removeFirst();
			if(check == ele[1]){
				res = ele[2];
				break;
			}
			for (int next : graph[ele[0]]) {
				if(!seen[next][ele[1] | (1<<next)]){
					queue.add(new int[]{next,ele[1] | (1<<next),ele[2]+1 });
					seen[next][ele[1] | (1<<next)] = true;
				}

			}
		}


		return res;
	}
}
