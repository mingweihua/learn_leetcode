package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ques451 {
	
	
	public static void main(String[] args) {

	}


	public String frequencySort(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
		}

		PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			queue.add(entry);
		}

		StringBuilder sb = new StringBuilder();
		char temp;
		while (!queue.isEmpty()) {
			Map.Entry<Character, Integer> ele =  queue.remove();
			temp = ele.getKey();
			for (int i = 0; i < ele.getValue(); i++) {
				sb.append(temp);
			}
		}
		return sb.toString();
	}
}
