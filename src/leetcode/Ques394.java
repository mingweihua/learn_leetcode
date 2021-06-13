package leetcode;

import java.util.ArrayList;

public class Ques394 {

	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(new Ques394().decodeString(s));
	}

	public String decodeString(String s) {
		ArrayList<String> stack = new ArrayList<String>();
		StringBuilder str; 
		StringBuilder res = new StringBuilder(); 
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == ']') {
				str = new StringBuilder();
				while(!stack.isEmpty() && !stack.get(stack.size()-1).equals("[")) {
					str.insert(0, stack.remove(stack.size()-1));
				}
				if(!stack.isEmpty() && stack.get(stack.size()-1).equals("[")) {
					stack.remove(stack.size()-1);
					getComponent(stack,str);
				}
				stack.add(str.toString());
			} else {
				stack.add(Character.toString(s.charAt(i)));
			}
		}
		while(!stack.isEmpty()) {
			res.insert(0, stack.remove(stack.size()-1));
		}
		return res.toString();
    }
	
	public void getComponent(ArrayList<String> stack, StringBuilder str) {
		StringBuilder num  = new StringBuilder();
		char charForStr;
		while(!stack.isEmpty()) {
			charForStr = stack.get(stack.size()-1).toCharArray()[0]; 
			if(charForStr>='0' && charForStr <= '9') {
				num.insert(0, stack.remove(stack.size()-1));
			} else {
				break;
			}		
		}
		int n = Integer.valueOf(num.toString());
		if(n == 1 || str.length()==0) {
			return;
		}
		if(n == 0) {
			str.delete(0, str.length());
			return;
		}	
		String s = str.toString();
		for(int i=1;i<n;i++) {
			str.append(s);
		}
    }
	
}
