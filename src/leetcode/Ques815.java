package leetcode;


import java.util.*;

public class Ques815 {

	public static void main(String[] args) {

	}


	//使用广度优先搜索，超出时间限制了
	//官方答案也是广度优先搜索，但是它弄出的map不是HashMap<Integer,List<int[]>> 这样后续遍历复杂度很高
	public int numBusesToDestination(int[][] routes, int source, int target) {
		int step = 0;
		if(target == source){
			return step;
		}

		HashMap<Integer,List<int[]>> map =new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			int[] temp = routes[i];
			for (int j = 0; j < temp.length; j++) {
				if(map.containsKey(temp[j])){
					map.get(temp[j]).add(temp);
				} else {
					List<int[]> one = new LinkedList<>();
					one.add(temp);
					map.put(temp[j],one);
				}
			}
		}


		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		int temp = 0;
		while(!queue.isEmpty()){
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				temp = queue.remove();
				List<int[]> bus_all = map.get(temp);
				for (int[] bus : bus_all) {
					for (int j = 0; j < bus.length; j++) {
						if(bus[j] == target){
							return step;
						}
						if(!visited.contains(bus[j])){
							visited.add(bus[j]);
							queue.add(bus[j]);
						}
					}
				}
			}
		}
		return -1;
	}

	//自己的方法优化一下
	//最后还是超时
	public int numBusesToDestination2(int[][] routes, int source, int target) {
		int step = 0;
		if(target == source){
			return step;
		}

		HashMap<Integer,HashSet<Integer>> map =new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			int[] temp = routes[i];
			for (int j = 0; j < temp.length; j++) {
				HashSet<Integer> direct = map.getOrDefault(temp[j],new HashSet<Integer>());
				for (int ele : temp){
					direct.add(ele);
				}
				map.put(temp[j],direct);
			}
		}


		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		int temp = 0;
		while(!queue.isEmpty()){
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				temp = queue.remove();
				if(map.containsKey(temp)){
					HashSet<Integer> direct = map.get(temp);
					for (int ele : direct) {
						if(ele == target){
							return step;
						}
						if(!visited.contains(ele)){
							visited.add(ele);
							queue.add(ele);
						}
					}
				}
			}
		}
		return -1;
	}

	//看了答案优化的
	public int numBusesToDestination3(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}

		int n = routes.length;
		boolean[][] edge = new boolean[n][n];

		Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n; i++) {
			for (int site : routes[i]) {
				List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
				for (int j : list) {
					edge[i][j] = edge[j][i] = true;
				}
				list.add(i);
				rec.put(site, list);
			}
		}

		int[] dis = new int[n];
		Arrays.fill(dis, -1);
		Queue<Integer> que = new LinkedList<Integer>();
		for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
			dis[bus] = 1;
			que.offer(bus);
		}
		while (!que.isEmpty()) {
			int x = que.poll();
			for (int y = 0; y < n; y++) {
				if (edge[x][y] && dis[y] == -1) {
					dis[y] = dis[x] + 1;
					que.offer(y);
				}
			}
		}

		int ret = Integer.MAX_VALUE;
		for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
			if (dis[bus] != -1) {
				ret = Math.min(ret, dis[bus]);
			}
		}
		return ret == Integer.MAX_VALUE ? -1 : ret;


	}

}
