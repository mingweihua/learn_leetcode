package leetcode.second;


import java.util.*;

public class Ques438 {


	public List<Integer> findAnagrams(String s, String p) {
		if (s.length() < p.length()) {
			return Collections.emptyList();
		}
		Map<Character, Integer> target = new HashMap<>();
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			target.put(c, target.getOrDefault(c, 0) + 1);
			char c2 = s.charAt(i);
			map.put(c2, map.getOrDefault(c2, 0) + 1);
		}
		if (compare(map, target)) {
			res.add(0);
		}
		int right = p.length();
		for (; right < s.length(); right++) {
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);

			char c2 = s.charAt(right - p.length());
			if (map.get(c2) == 1) {
				map.remove(c2);
			} else {
				map.put(c2, map.get(c2) - 1);
			}
			if (compare(map, target)) {
				res.add(right - p.length() + 1);
			}
		}
		return res;
	}

	public boolean compare(Map<Character, Integer> map, Map<Character, Integer> target) {
		if (map.size() != target.size()) {
			return false;
		}
		for (Character k : map.keySet()) {
			if (!target.containsKey(k)) {
				return false;
			}
			int i = map.get(k);
			int j = target.get(k);
			if (i != j) {
				return false;
			}
		}
		return true;
	}

	// 上面的方法其实是m+ (n-m) * m 时间复杂度，还能更加优化
	// leetcode官方解答
	// 由于需要统计每个字符，即每个字符的数量，因此会出现n*m的时间复杂度。假设不统计这个维度，通过diff记录子串与p之间不同的字符个数
	// 只需判断diff == 0即可
	public List<Integer> findAnagrams2(String s, String p) {
		if (s.length() < p.length()) {
			return Collections.emptyList();
		}
		Map<Character, Integer> diffMap = new HashMap<>(); //添加一个s里字符进行-1， 添加一个p里字符+1
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			int num = diffMap.getOrDefault(c, 0) + 1;
			if (num == 0) {
				diffMap.remove(c);
			} else {
				diffMap.put(c, num);
			}

			char c2 = s.charAt(i);
			num = diffMap.getOrDefault(c2, 0) - 1;
			if (num == 0) {
				diffMap.remove(c2);
			} else {
				diffMap.put(c2, num);
			}
		}
		int diff = diffMap.size();
		if (diff == 0) {
			res.add(0);
		}

		int right = p.length();
		for (; right < s.length(); right++) {
			char c = s.charAt(right);
			int num = diffMap.getOrDefault(c, 0) - 1;
			if (num == 0) {
				diffMap.remove(c);
			} else {
				diffMap.put(c, num);
			}

			char c2 = s.charAt(right - p.length());
			num = diffMap.getOrDefault(c2, 0) + 1;
			if (num == 0) {
				diffMap.remove(c2);
			} else {
				diffMap.put(c2, num);
			}
			diff = diffMap.size();
			if (diff == 0) {
				res.add(right - p.length() + 1);
			}
		}
		return res;
	}
}
