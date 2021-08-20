package leetcode;

public class Ques541 {

	public static void main(String[] args) {
		
	}


	public String reverseStr(String s, int k) {
		if(s==null || s.length() == 0 || s.length() == 1 || k==1){
			return s;
		}
		char[] chars = s.toCharArray();
		int cur = 0;
		int next = 0;
		int last = s.length()-1;
		boolean change = true;
		while (cur <= last){
			next = Math.min(cur+k-1,last);
			if(change){
				reverseStr(chars,cur,next);
				change = false;
			} else {
				change = true;
			}
			cur = next+1;
		}
		return new String(chars);
	}


	public void reverseStr(char[] chars, int start,int end) {
		char[] temp = new char[end-start+1];
		for (int i = start; i <= end; i++) {
			temp[i-start] = chars[i];
		}
		for (int i = start; i <= end; i++) {
			chars[i] = temp[end-i];
		}
	}
}
