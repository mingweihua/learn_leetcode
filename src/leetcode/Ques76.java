package leetcode;

import java.util.HashMap;

public class Ques76 {

	public static void main(String[] args) {
		String s = "ab";
				
		String t = "b";
		new Ques76().minWindow(s,t);
	}


	public String minWindow(String s, String t) {
        if(s.length() == 1 && t.length() == 1){
            if(s.equals(t)) {
                return t;
            }
            return "";
        }
        HashMap<Character,Integer> data = new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
            char k = t.charAt(i);
            data.put(k,data.getOrDefault(k, 0)+1);
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int first = 0;
        int last = 0;
        int min = s.length();
        int min_first = 0;
        boolean checked = false;
        while(last<s.length()) {
        	char key = s.charAt(last);
        	if(!check(data,map) && data.containsKey(key)) {
        		map.put(key,map.getOrDefault(key, 0)+1);
        		last++;
        		continue;
        	}
        	if(!check(data,map) && !data.containsKey(key)) {
        		last++;
        		continue;
        	}
        	if(check(data,map)) {
        		checked = true;
        		while(check(data,map) && first<last) {
            		int temp = last - first;
            		if(temp<min) {
            			min = temp;
            			min_first = first;
            		}
            		char k = s.charAt(first);
            		if(map.containsKey(k)) {
            			int num = map.get(k);
            			if(num <= 1) {
            				map.remove(k);
            			} else {
            				map.put(k, num-1);
            			}
            		}
            		first++;
        		}
        	}
        }     
        if(check(data,map)) {
        	checked = true;
        	while(check(data,map) && first<last) {
        		int temp = last - first;
        		if(temp<min) {
        			min = temp;
        			min_first = first;
        		}
        		char k = s.charAt(first);
        		if(map.containsKey(k)) {
        			int num = map.get(k);
        			if(num <= 1) {
        				map.remove(k);
        			} else {
        				map.put(k, num-1);
        			}
        		}
        		first++;
    		}
        }
        if(!checked) {
        	return "";
        }
		return s.substring(min_first, min_first+min);	
    }
	public boolean check(HashMap<Character,Integer> data, HashMap<Character,Integer> map) {
		if(data.size() != map.size()) {
			return false;
		}
		for(Character key : data.keySet()) {
			if(map.get(key) < data.get(key)) {
				return false;
			}
		}
		return true;
	}
}
