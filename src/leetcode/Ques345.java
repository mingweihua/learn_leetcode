package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class Ques345 {

	public static void main(String[] args) {
		
	}
	//自己写的，双指针才是最优的
	public String reverseVowels(String s) {
		if(s==null || s.length() == 0 || s.length() == 1){
			return s;
		}
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		char[] chars = s.toCharArray();
		LinkedList<Character> charList = new LinkedList<>();
		LinkedList<Integer> positionList = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if(set.contains(cur)){
				charList.addFirst(cur);
				positionList.addLast(i);
			} else {
				chars[i] = cur;
			}
		}
		for (int i = 0; i < charList.size(); i++) {
			chars[positionList.get(i)] = charList.get(i);
		}
		return new String(chars);
	}


	//双指针
	public String reverseVowels2(String s) {
		if(s==null || s.length() == 0 || s.length() == 1){
			return s;
		}
		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		char[] chars = new char[s.length()];
		int left = 0;
		int right = chars.length-1;
		while (left<right){
			while (left<right && !set.contains(chars[left])){
				left++;
			}
			if(left >= right){
				break;
			}
			while (left<right && !set.contains(chars[right])){
				right--;
			}
			if(left >= right){
				break;
			}
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}

		return new String(chars);
	}
}
