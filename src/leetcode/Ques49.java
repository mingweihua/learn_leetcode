package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Ques49 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	//自己写的方法超时了
	
	//力扣上面的方法
	//1.排序  时间复杂度  O(nklogk)
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String string = new String(chars);
			List<String> list = map.getOrDefault(string, new ArrayList<String>());
			list.add(strs[i]);
			map.put(string, list);
		}	
		return new ArrayList<List<String>>(map.values()); 
    }
	
	//2.计数（数组） 时间复杂度  O(nk)
	public List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++) {
			int[] arr = new int[26];
			for(int j=0;j<strs[i].length();j++) {
				arr[strs[i].charAt(j) - 'a']++; 
			}
			
			StringBuilder sb = new StringBuilder();
			for(int k=0;k<arr.length;k++) {
				sb.append((char)('a' + k));
				sb.append(arr[k]);
			}
			
			String key = sb.toString();
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(strs[i]);
			map.put(key, list);
		}	
		return new ArrayList<List<String>>(map.values()); 
    }
}
