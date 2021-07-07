package leetcode;

import java.util.*;

public class Ques1418 {



	public List<List<String>> displayTable(List<List<String>> orders) {
		TreeSet<String> display = new TreeSet<>();
		TreeMap<Integer,TreeMap<String,Integer>> map = new TreeMap<>();
		for (List<String> order : orders) {
			TreeMap<String,Integer> table_order = map.getOrDefault(Integer.valueOf(order.get(1)),new TreeMap<>());
			table_order.put(order.get(2),table_order.getOrDefault(order.get(2),0)+1);
			display.add(order.get(2));
			map.put(Integer.valueOf(order.get(1)),table_order);
		}

		List<List<String>> res = new ArrayList<>();
		List<String> menu = new ArrayList<>();
		menu.add("Table");
		menu.addAll(display);
		res.add(menu);
		System.out.println(map.size());
		while(!map.isEmpty()){
			List<String> one = new ArrayList<>();
			Map.Entry<Integer,TreeMap<String,Integer>> ele = map.pollFirstEntry();
			one.add(String.valueOf(ele.getKey()));
			TreeMap<String,Integer> table_order = ele.getValue();
			for (int j = 1; j < menu.size(); j++) {
				one.add(String.valueOf(table_order.getOrDefault(menu.get(j),0)));
			}
			res.add(one);
		}

		return res;
	}

}
