package leetcode;

import java.util.HashSet;

public class Ques4 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int lengthOfLongestSubstring(String s) {
        if(s.length() <=1 ){
            return s.length();
        }
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 1;
        int maxLength = 0;
        set.add(s.charAt(left));
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                while(set.contains(s.charAt(right))){
                	set.remove(s.charAt(left));
                    left++;
                }
            } else {
            	set.add(s.charAt(right));
                right++;
                
            }
            maxLength = Math.max(maxLength,(right-left));
        }
        return maxLength;
    }
}
