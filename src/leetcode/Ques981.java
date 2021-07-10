package leetcode;


import java.util.*;

public class Ques981 {

	public static void main(String[] args) {
		
	}

	class TimeMap {
		HashMap<String, TreeMap<Integer,String>> map;
		/** Initialize your data structure here. */
		public TimeMap() {
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			TreeMap<Integer,String> treeMap = map.getOrDefault(key,new TreeMap<>());
			treeMap.put(timestamp,value);
			map.put(key,treeMap);
		}

		public String get(String key, int timestamp) {
			if(!map.containsKey(key)){
				return "";
			}
			TreeMap<Integer,String> treeMap = map.get(key);
			Map.Entry<Integer, String> integerStringEntry = treeMap.floorEntry(timestamp);
			if (integerStringEntry == null){
				return "";
			}
			return integerStringEntry.getValue();
		}
	}
}
