package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques401 {
	
	
	public static void main(String[] args) {

	}

	List<String> res;
	List<String> hours;
	List<String> mins;
	public List<String> readBinaryWatch(int turnedOn) {
		res = new ArrayList<>();
		if(turnedOn>8 || turnedOn < 0){
			return res;
		}

		int min = 0;
		for (int hour = 0; hour <= 3; hour++) {
			min = turnedOn - hour;
			if(min<0 || min > 5){
				continue;
			}
			hours = new ArrayList<>();
			mins = new ArrayList<>();
			if(hour == 0){
				hours.add("0");
			} else {
				dfs(0,0,hour,true,11,hours);
			}
			if(min == 0){
				mins.add("00");
			} else {
				dfs(0,0,min,false,59,mins);
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < hours.size(); i++) {
				sb.append(hours.get(i));
				sb.append(":");
				for (int j = 0; j < mins.size(); j++) {
					int start = sb.length();
					sb.append(mins.get(j));
					res.add(sb.toString());
					sb.delete(start,sb.length());
				}
				sb.delete(0,sb.length());
			}

		}
		return res;
	}



	public void dfs(int cur,int move,int left,boolean isHour,int max,List<String> temp) {
		if(cur > max){
			return;
		}
		if(left == 0){
			if(!isHour && cur<10){
				temp.add("0" + String.valueOf(cur));
			} else {
				temp.add(String.valueOf(cur));
			}
			return;
		}
		for (int i=move;i<=5;i++){
			dfs(cur+(1<<i),i+1,left-1,isHour,max,temp);
		}

	}


	//官方答案
	/*
	作者：LeetCode-Solution
	链接：https://leetcode-cn.com/problems/binary-watch/solution/er-jin-zhi-shou-biao-by-leetcode-solutio-3559/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public List<String> readBinaryWatch2(int turnedOn) {
		List<String> ans = new ArrayList<String>();
		for (int h = 0; h < 12; ++h) {
			for (int m = 0; m < 60; ++m) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
					ans.add(h + ":" + (m < 10 ? "0" : "") + m);
				}
			}
		}
		return ans;
	}

}
