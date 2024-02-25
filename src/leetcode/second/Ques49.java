package leetcode.second;

import java.util.*;


public class Ques49 {


	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> resMap = new HashMap<>();
		for (String str : strs) {
			String parseStr = parseStr(str);
			List<String> list = resMap.computeIfAbsent(parseStr, k -> new ArrayList<>());
			list.add(str);
		}
		return new ArrayList<>(resMap.values());
	}

	private String parseStr(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
