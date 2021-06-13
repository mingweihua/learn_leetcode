package leetcode;

import java.util.LinkedList;

public class Ques772 {

	public static void main(String[] args) {
		System.out.println(new Ques772().calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
	}

	public int calculate(String s) {
		if(s.length() == 1) {
			return Integer.valueOf(s);
		}
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> list_operate = new LinkedList<String>();
		//ArrayList<String> list = new ArrayList<String>();
		int cur = 0;
		String num_str = null;
		String num_pre_str = null;
		String ope = null;
		while(cur < s.length()) {
			if(s.charAt(cur) - '0'>=0 && s.charAt(cur) - '0'<=9) {
				num_str = getNumStr(s, cur);
				list.addLast(num_str);
				cur = cur + num_str.length();
				continue;
			}
			if(s.charAt(cur) == '*' || s.charAt(cur) == '/') {
				if(s.charAt(cur+1) - '0'>=0 && s.charAt(cur+1) - '0'<=9) {
					num_str = getNumStr(s, cur+1);
					num_pre_str = list.removeLast();
					list.addLast(operate(num_pre_str,num_str,""+s.charAt(cur)));
					cur = cur +1 +num_str.length();
					continue;
				} else {
					list.addLast(""+ s.charAt(cur));
					cur++;
					continue;
				}
			}
			if(s.charAt(cur) == ')') {
				while(!list.getLast().equals("(")) {
					list_operate.addLast(list.removeLast());
				}
				list.removeLast();
				while(!list_operate.isEmpty()) {
					num_pre_str = list_operate.removeLast();
					if(list_operate.isEmpty()) {
						break;
					} else {
						ope = list_operate.removeLast();
						num_str = list_operate.removeLast();
						list_operate.addLast(operate(num_pre_str,num_str,ope));
					}
				}
				num_str = num_pre_str;			
				//判断前面是否是乘除
				if(!list.isEmpty() && 
						(list.getLast().equals("*") || list.getLast().equals("/"))) {
					ope = list.removeLast();
					num_pre_str = list.removeLast();
					num_str = operate(num_pre_str,num_str,ope);
				}
				list.addLast(num_str);
				cur++;
			} else {
				list.addLast(""+ s.charAt(cur));
				cur++;
			}
		}
		
		while(!list.isEmpty()) {
			num_pre_str = list.removeFirst();
			if(list.isEmpty()) {
				return Integer.valueOf(num_pre_str);
			} else {
				ope = list.removeFirst();
				num_str = list.removeFirst();
				list.addFirst(operate(num_pre_str,num_str,ope));
			}
		}
		
		return 0;
    }
	
	public String getNumStr(String s, int start) {
		int cur = start;
		while(cur < s.length() && s.charAt(cur) - '0'>=0 && s.charAt(cur) - '0'<=9 ) {
			cur++;
		}
		return s.substring(start, cur);
	}
	
	
	public String operate(String num1,String num2, String ope) {
		int n1 = Integer.valueOf(num1);
		int n2 = Integer.valueOf(num2);
		switch (ope) {
			case "*":
				return String.valueOf(n1*n2);
			case "/":
				return String.valueOf(n1/n2);
			case "+":
				return String.valueOf(n1+n2);
			case "-":
				return String.valueOf(n1-n2);			
		}
		return "";
	}
}
