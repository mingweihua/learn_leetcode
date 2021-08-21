package leetcode;

import java.util.ArrayList;

public class Ques443 {
	
	
	public static void main(String[] args) {
		
	}

	public int compress(char[] chars) {
		if(chars.length <= 1){
			return chars.length;
		}
		int pre = -1;
		int cur = 0;
		int next = 0;
		while (cur<chars.length){
			next = cur+1;
			while (next<chars.length && chars[cur] == chars[next]){
				next++;
			}
			chars[++pre] = chars[cur];
			int temp = next - cur;
			if(temp>1 && temp<10){
				chars[++pre] = (char) ('0'+temp);
			}
			if(temp>=10){
				char[] num = String.valueOf(temp).toCharArray();
				for (int i = 0; i < num.length; i++) {
					chars[++pre] = num[i];
				}
			}
			cur = next;
		}
		return pre+1;
	}
}
