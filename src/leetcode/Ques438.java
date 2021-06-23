package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ques438 {

	public static void main(String[] args) {
		String s= "cbaebabacd";
		String p = "abc";
		System.out.println(new Ques438().findAnagrams(s,p));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		int window = 0;
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)-1);
		}
		int start = 0;
		char temp;
		char pre;
		while (start<s.length()){
			temp = s.charAt(start);
			if(map.containsKey(temp)){
				if(window==p.length()){
					pre  = s.charAt(start-window);
					map.put(pre,map.get(pre)-1);
					window--;
				}

				map.put(temp,map.get(temp)+1);
				window++;
				if(window == p.length() && checkChars(map)){
					res.add(start-window+1);
				}

			} else {
				while(window>0){
					pre  = s.charAt(start-window);
					map.put(pre,map.get(pre)-1);
					window--;
				}

			}
			start++;
		}
		return res;
	}

	public boolean checkChars(HashMap<Character,Integer> map){
		for (Character key : map.keySet()){
			if(map.get(key) != 0){
				return false;
			}
		}
		return true;
	}
}
