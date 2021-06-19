package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ques1239 {

	public static void main(String[] args) {
		String[] s = {"un","iq","ue"};
		List<String> arr = new ArrayList<>(Arrays.asList(s));
		System.out.println(new Ques1239().maxLength(arr));
	}

	List<int[]> list;
	int res = 0;
	public int maxLength(List<String> arr) {
		list = new ArrayList<>();
		int[] ele;
		String temp;
		int moudle = 1;

		for (int i = 0; i < arr.size(); i++) {
			ele = new int[2];
			temp = arr.get(i);
			ele[1] = temp.length();
			for (int j = 0; j < temp.length(); j++) {
				moudle = 1;
				if((ele[0] & (moudle = moudle << (temp.charAt(j) - 'a')) ) != 0){
					ele[0] = -1;
					break;
				} else {
					ele[0] = ele[0] | moudle;
				}
			}
			list.add(ele);
		}
		int curLength = 0;
		for (int i = 0; i < list.size(); i++) {
			ele = list.get(i);
			if(ele[0] == -1){
				continue;
			}
			curLength = ele[1];
			res = Math.max(res,curLength);
			dfs(i,ele[0],curLength);
		}
		return res;
	}

	public void dfs(int cur,int mod,int curLength) {
		if(cur == list.size()-1){
			return;
		}
		int[] ele;
		for(int i=cur+1;i<list.size();i++){
			ele = list.get(i);
			if(ele[0] == -1){
				continue;
			}
			if ((mod & ele[0]) != 0){
				continue;
			}
			res = Math.max(res,curLength+ele[1]);
			dfs(i,mod|ele[0],curLength+ele[1]);
		}
	}

}
