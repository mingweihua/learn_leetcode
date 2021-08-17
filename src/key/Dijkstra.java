package key;

import java.util.Arrays;
import java.util.LinkedList;

public class Dijkstra {

	public static void main(String[] args) {

	}
	//对应Leetcodde的743题

	//自己想的BFS求解最短路径难点在于如何解决有环问题，因为最短路径中，节点以及同一条边是有可能重复走的
	//解决方法：当【重复】走到某一个节点，发现其路径并没有比原来少，那么这个节点邻接点就可以不加入到队列中
	//实际运行时间是比Dijkstra 算法（迪杰斯特拉算法）要久一点

	//感觉有点像Ford算法
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] score = new int[n+1];
		Arrays.fill(score,Integer.MAX_VALUE);

		int[][] edges = new int[n+1][n+1];
		for (int[] edge :  edges) {
			Arrays.fill(edge,-1);
		}

		for (int[] time : times) {
			edges[time[0]][time[1]] = time[2];
		}
		LinkedList<int[]> queue = new LinkedList<>();
		int[] cur = {k,0};
		queue.add(cur);
		while (!queue.isEmpty()){
			cur = queue.remove();
			int index = cur[0];
			if(score[index] > cur[1]){
				score[index] = cur[1];
				for (int j = 1; j < edges[index].length; j++) {

					if(edges[index][j] != -1){
						int[] ele = {j,cur[1] + edges[index][j]};
						queue.add(ele);

					}
				}
			}
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			if(score[i] == Integer.MAX_VALUE){
				return -1;
			}
			res = Math.max(res,score[i]);
		}
		return res;
	}


	/*
		官方答案：
		方法一：Dijkstra 算法（迪杰斯特拉算法）
		根据题意，从节点 k发出的信号，到达节点  的时间就是节点 k 到节点 x 的最短路的长度。
		因此我们需要求出节点 k 到其余所有点的最短路，其中的最大值就是答案。若存在从 k 出发无法到达的点，则返回 −1。

		下面的代码将节点编号减小了 1，从而使节点编号位于 [0,n-1]范围。

		作者：LeetCode-Solution
		链接：https://leetcode-cn.com/problems/network-delay-time/solution/wang-luo-yan-chi-shi-jian-by-leetcode-so-6phc/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */

	/*

			1.首先，Dijkstra 算法需要存储各个边权，由于本题节点数量不超过 100，所以代码中使用了邻接矩阵 g[i][j] 存储从点 i 到点 j 的距离。
			若两点之间没有给出有向边，则初始化为 inf。算法还需要记录所有点到源点的最短距离，代码中使用了 dist[i] 数组存储源点到点 i 的最短距离，
			初始值也全部设为 inf。由于本题源点为 K，所以该点距离设为 0。
			2.其次，Dijkstra 算法需要标记某一节点是否已确定了最短路，在代码中使用了 used[i] 数组存储，
			若已确定最短距离，则值为 true，否则值为 false。

	 */

	public int networkDelayTime2(int[][] times, int n, int k) {
		final int INF = Integer.MAX_VALUE / 2;
		int[][] g = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(g[i], INF);
		}
		for (int[] t : times) {
			int x = t[0] - 1, y = t[1] - 1;
			g[x][y] = t[2];
		}

		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		// 由于从 k 开始，所以该点距离设为 0，也即源点
		dist[k - 1] = 0;
		// 节点是否被更新数组
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; ++i) {
			// 在还未确定最短路的点中，寻找距离最小的点，因此第一次进来肯定会找到源点
			int x = -1;
			for (int y = 0; y < n; ++y) {
				if (!used[y] && (x == -1 || dist[y] < dist[x])) {
					x = y;
				}
			}

			// 用该点更新所有其他点的距离
			used[x] = true;
			for (int y = 0; y < n; ++y) {
				dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
			}
		}

		// 找到距离最远的点
		int ans = Arrays.stream(dist).max().getAsInt();
		return ans == INF ? -1 : ans;
	}


	//时间复杂度优化：Dijkstra 算法（迪杰斯特拉算法）使用枚举 --> 适用于稠密图
	//除了枚举，我们还可以使用一个小根堆来寻找「未确定节点」中与起点距离最近的点 --> 适用于稀疏图 。
}
