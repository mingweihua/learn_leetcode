package leetcode;

import java.util.HashMap;

public class Ques159 {

	public static void main(String[] args) {
		
	}
	

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int start = 0;
		int end = 0;	
		while(end<s.length()) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
			while(map.size()>2) {
				int temp = map.get(s.charAt(start));
				if(temp == 1) {
					map.remove(s.charAt(start));
				} else {
					map.put(s.charAt(start), temp-1);
				}
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;
    }
}
