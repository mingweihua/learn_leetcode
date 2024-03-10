package leetcode.second;

import java.util.*;

public class Ques3 {

	// 无重复字符的最长子串
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		int pointer = 0;
		int maxLength = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (set.size() > 0 && set.contains(c)) {
				set.remove(s.charAt(pointer));
				pointer++;
			}
			set.add(c);
			maxLength = Math.max(maxLength, set.size());
		}
		return maxLength;
	}
}
