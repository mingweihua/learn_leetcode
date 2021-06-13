package leetcode;

import java.util.HashMap;

public class Ques89 {

	public static void main(String[] args) {
		
	}
	
	int[][][] dp;
	
	public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
        	return false;
        }
        if(s1.equals(s2)) {
        	return true;
        }
        dp = new int[s1.length()][s1.length()][s1.length()+1];
        isScramble(s1,0,s2,0,s1.length());
        return dp[0][0][s1.length()] == 1;
    }
	
	public boolean isScramble(String s1,int start1, String s2, int start2,int length) {
		if(dp[start1][start2][length] != 0) {
			return dp[start1][start2][length] ==1;
		}
		if(s1.subSequence(start1, start1+length).equals(s2.substring(start2, start2+length))) {
			dp[start1][start2][length] = 1;
			return true;
		}
		if(!checkIfSimilar(s1,start1,s2,start2,length)) {
			dp[start1][start2][length] = -1;
			return false;
		}
	
		for(int i=1;i<length;i++) {
			if(isScramble(s1,start1,s2,start2,i) && isScramble(s1,start1+i,s2,start2+i,length-i)) {
				dp[start1][start2][length] = 1;
				return true;
			}
			if(isScramble(s1,start1,s2,start2+length-i,i) && isScramble(s1,start1+i,s2,start2,length-i)) {
				dp[start1][start2][length] = 1;
				return true;
			}
		}
		dp[start1][start2][length] = -1;
		return false;
	}
	
	public boolean checkIfSimilar(String s1,int start1, String s2, int start2,int length) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=start1;i<start1+length;i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
		}	
		for(int i=start2;i<start2+length;i++) {
			if(!map.containsKey(s2.charAt(i))) {
				return false;
			} else {
				int temp = map.get(s2.charAt(i));
				temp--;
				if(temp == 0) {
					map.remove(s2.charAt(i));
				} else {
					map.put(s2.charAt(i), temp);
				}
			}
		}
		if(map.size()!=0) {
			return false;
		}
        return true;
    }

}
