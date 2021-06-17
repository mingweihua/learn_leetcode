package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Ques621 {

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;
		System.out.println(new Ques621().leastInterval(tasks,n));
	}


	//方法1 模拟，但是时间复杂度挺高的，差点就超时
	public int leastInterval(char[] tasks, int n) {
		int res = 0;
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]){
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1];
				}
			}
		});
		for (Character key : map.keySet()){
			int[] ele = new int[2];
			ele[1] = map.get(key);
			queue.add(ele);
		}
		int[] temp;
		while(!queue.isEmpty()){
			temp = queue.remove();
			if(temp[1] <= 0){
				continue;
			}
			if(temp[0] > 0){
				temp[0]--;
			} else {
				temp[0] = n;
				temp[1]--;
			}
			queue = timeRest(queue);
			res++;
			if(temp[1] > 0){
				queue.add(temp);
			}

		}
		return res;
	}

	public PriorityQueue<int[]> timeRest(PriorityQueue<int[]> queue) {
		if(queue.isEmpty()){
			return queue;
		}
		PriorityQueue<int[]> newQueue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]){
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1];
				}
			}
		});
		int[] temp;
		while(!queue.isEmpty()){
			temp = queue.remove();
			if(temp[0]>0){
				temp[0]--;
			}
			newQueue.add(temp);
		}
		return newQueue;
	}

	//方法2：构造，查看leetcode答案
	public int leastInterval2(char[] tasks, int n) {
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
		}
		int maxCount = 0;
		int maxLength = 0;
		int temp= 0;
		for (Character key : map.keySet()){
			temp = map.get(key);
			if(temp > maxLength){
				maxLength = temp;
				maxCount = 1;
			} else if(temp ==  maxLength){
				maxCount++;
			}
		}
		return Math.max((maxLength-1) * (n+1)+maxCount,tasks.length);
	}

	//优化一下时间
	public int leastInterval3(char[] tasks, int n) {
		HashMap<Character,Integer> map = new HashMap<>();
		int temp= 0;
		int maxCount = 0;
		int maxLength = 0;
		for (int i = 0; i < tasks.length; i++) {
			temp = map.getOrDefault(tasks[i],0)+1;
			if(temp > maxLength){
				maxLength = temp;
				maxCount = 1;
			} else if(temp ==  maxLength){
				maxCount++;
			}
			map.put(tasks[i],temp);
		}

		return Math.max((maxLength-1) * (n+1)+maxCount,tasks.length);
	}
}
