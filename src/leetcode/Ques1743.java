package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ques1743 {

	public static void main(String[] args) {
		int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
		System.out.println(new Ques1743().restoreArray(adjacentPairs));
	}

	public int[] restoreArray(int[][] adjacentPairs) {
		int n = adjacentPairs.length+1;
		HashMap<Integer, List<Integer>> map = new HashMap<>(n);
		int temp1 = 0;
		int temp2 = 0;
		for (int[] adjacentPair : adjacentPairs) {
			temp1 = adjacentPair[0];
			temp2 = adjacentPair[1];
			List<Integer> list1 = map.getOrDefault(temp1,new ArrayList<>());
			List<Integer> list2 = map.getOrDefault(temp2, new ArrayList<>());
			list1.add(temp2);
			list2.add(temp1);
			map.put(temp1,list1);
			map.put(temp2,list2);
		}
		int cur = 0;
		int next = 0;
		List<Integer> list;
		for(Integer key : map.keySet()){
			if(( list = map.get(key)).size() == 1){
				cur = key;
				next = list.get(0);
				break;
			}
		}
		int[] res = new int[n];
		res[0] = cur;
		res[1] = next;
		cur = next;
		for (int i = 2; i < n; i++) {
			list = map.get(cur);
			for (int j = 0; j < list.size(); j++) {
				if((next = list.get(j)) != res[i-2]){
					res[i] = next;
					break;
				}
			}
			cur = next;
		}
		return res;
	}


}
