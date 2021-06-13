package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Ques179 {
	
	public static void main(String[] args) {

	}
	
	
	public String largestNumber(int[] nums) {
		StringBuilder result = new StringBuilder();
		String[] strs = new String[nums.length];
		for(int i=0;i<nums.length;i++) {
			strs[i] = ""+nums[i];
		}
		Arrays.sort(strs,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int n1 = o1.length();
	            int n2 = o2.length();
	            int min = Math.min(n1, n2);
	            for(int i=0;i<min;i++) {
	            	char c1 = o1.charAt(i);
	            	char c2 = o2.charAt(i);
	            	if(c1!=c2) {
	            		return c2-c1;
	            	}
	            }
	            if(n1 == n2) {
	            	return 0;
	            }
	            Long num1 = Long.valueOf(o1+o2);
	            Long num2 = Long.valueOf(o2+o1);
	            if(num1 == num2) {
	            	return n1-n2;
	            } else {
	            	return (int) (num2-num1);
	            }
                
			}
		});
		for(int i=0;i<nums.length;i++) {
			result.append(strs[i]);
		}
		while(result.length()>1 && result.charAt(0)=='0') {
			result.deleteCharAt(0);
		}
		return result.toString();       
    }
}
