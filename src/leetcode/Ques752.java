package leetcode;

import java.util.*;

public class Ques752 {

	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		System.out.println(new Ques752().openLock(deadends,target));
	}



	public int openLock(String[] deadends, String target) {
		if(target.equals("0000")){
			return 0;
		}
		HashSet<String> lock = new HashSet<>();
		for (String ele : deadends) {
			lock.add(ele);
		}
		if(lock.contains("0000")){
			return -1;
		}

		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		visited.add("0000");
		queue.add("0000");
		int step = 0;
		int size = 0;
		String temp;
		while (!queue.isEmpty()) {
			step++;
			size = queue.size();
			for (int i = 0; i < size; i++) {
				temp = queue.remove();
				for (String ele : getNextStatus(temp)){
					if(target.equals(ele)){
						return step;
					}
					if(!visited.contains(ele) && !lock.contains(ele)){
						queue.add(ele);
						visited.add(ele);
					}
				}
			}

		}
		return -1;
	}



	public List<String> getNextStatus(String cur) {
		List<String> res = new ArrayList<>();
		char[] chars = cur.toCharArray();
		for (int i = 0; i < 4; i++) {
			if(chars[i] == '0') {
				chars[i] = '1';
				res.add(new String(chars));
				chars[i] = '9';
				res.add(new String(chars));
				chars[i] = '0';
			} else if (chars[i] == '9'){
				chars[i] = '0';
				res.add(new String(chars));
				chars[i] = '8';
				res.add(new String(chars));
				chars[i] = '9';
			} else {
				chars[i] += 1;
				res.add(new String(chars));
				chars[i] -= 2;
				res.add(new String(chars));
				chars[i] ++;
			}

		}
		return res;
	}

}
