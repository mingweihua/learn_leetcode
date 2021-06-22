package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ques301 {

	public static void main(String[] args) {
		
	}
	
	//官方答案的几个参数用得比较巧妙，思路清晰，深度遍历剪枝
	/*
		参考了答案自己写出来的
	 */
	List<String> res;
	HashSet<String> set = new HashSet<>();
	public List<String> removeInvalidParentheses(String s) {
		int leftRemove = 0;
		int rightRemove = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '('){
				leftRemove++;
			} else if (s.charAt(i) == ')'){
				if(leftRemove>0){
					leftRemove--;
				} else {
					rightRemove++;
				}
			}
		}
		dfs(chars,0,new StringBuilder(),0,0,leftRemove,rightRemove);
		res = new ArrayList<>(set);

		return res;
	}

	public void dfs(char[] chars, int cur, StringBuilder pre, int left, int right, int leftRemove, int rightRemove){
		if(cur == chars.length){
			if(leftRemove == 0 && rightRemove == 0){
				set.add(pre.toString());
			}
			return;
		}

		if(chars[cur] == '('){
			if(leftRemove > 0 && left>=right){
				dfs(chars,cur+1,pre,left,right,leftRemove-1,rightRemove);
			}
			pre.append(chars[cur]);
			dfs(chars,cur+1,pre,left+1,right,leftRemove,rightRemove);
			pre.deleteCharAt(pre.length()-1);
		} else if(chars[cur] == ')'){
			if(rightRemove>0){
				dfs(chars,cur+1,pre,left,right,leftRemove,rightRemove-1);
			}
			if(rightRemove == 0 && right>=left){
				return;
			}
			if(left>right){
				pre.append(chars[cur]);
				dfs(chars,cur+1,pre,left,right+1,leftRemove,rightRemove);
				pre.deleteCharAt(pre.length()-1);
			}

		} else {
			pre.append(chars[cur]);
			dfs(chars,cur+1,pre,left,right,leftRemove,rightRemove);
			pre.deleteCharAt(pre.length()-1);
		}

	}
}
