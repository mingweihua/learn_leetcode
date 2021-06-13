package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Ques692 {

	public static void main(String[] args) {
		
	}
	
	
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0)+1);
		}
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int num1 = o1.getValue();
				int num2 = o2.getValue();
				if(num1 != num2) {
					return num1 -num2;
				}
				return o2.getKey().compareToIgnoreCase(o1.getKey());
			}
		});
		for (Map.Entry<String, Integer> ele: map.entrySet()) {
			queue.add(ele);
			if (queue.size()>k) {
				queue.remove();
			}
		}
		LinkedList<String> res = new LinkedList<String>();
		while (!queue.isEmpty()) {
			res.addFirst(queue.remove().getKey());
		}	
		return res;
    }
}
