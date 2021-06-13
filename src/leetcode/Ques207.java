package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Ques207 {

	public static void main(String[] args) {
		
	}
	public boolean[] checked;
	public boolean[] pre;
	public HashMap<Integer, ArrayList<Integer>> map;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		checked = new boolean[numCourses];
		pre = new boolean[numCourses];
		map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (map.containsKey(prerequisites[i][0])) {
				map.get(prerequisites[i][0]).add(prerequisites[i][1]);
			} else {
				ArrayList<Integer> one = new ArrayList<Integer>();
				one.add(prerequisites[i][1]);
				map.put(prerequisites[i][0], one);
			}
		}
		boolean flag = false;
		for (Integer key : map.keySet()) {
			if(checked[key]) {
				continue;
			} else {
				pre[key] = true;
				flag = canFinish(map.get(key));
				if(!flag) {
					return false;
				}
				pre[key] = false;
				checked[key] = true;
			}
			
		}
		return true;
    }
	
	public boolean canFinish(ArrayList<Integer> path) {
		boolean flag = false;
		int index=0;
		for (int i = 0; i < path.size(); i++) {
			index = path.get(i);
			if(pre[index]) {
				return false;
			} else {
				if(checked[index]) {
					continue;
				} else {
					if(map.containsKey(index)) {
						pre[index] = true;
						flag = canFinish(map.get(index));
						if(!flag) {
							return false;
						}
						pre[index] = false;
						checked[index] = true;
					} else {
						checked[index] = true;
					}			
				}
			}
		}
		
		return true;
    }
}