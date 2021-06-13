package leetcode;

import java.util.ArrayList;

public class Ques1006 {

	public static void main(String[] args) {
		
	}

	public int clumsy(int N) {
		if(N<=2) {
			return N;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(N--);
		int cur = 0;
		while(N>=1) {
			if(cur == 0) {
				int temp = list.remove(list.size()-1);
				temp *= N;
				list.add(temp);
				N--;
				cur++;
				continue;
			}
			if(cur == 1) {
				int temp = list.remove(list.size()-1);
				temp =  (int) Math.floor(((double)temp)/N);
				list.add(temp);
				N--;
				cur++;
				continue;
			}
			
			list.add(N--);
			
			if(cur==3) {
				cur = 0;
			} else {
				cur++;
			}
		}
		int sum = list.get(0);
		for(int i=1;i<list.size();i++) {
			if(i%2 == 0) {
				sum -= list.get(i);
			} else {
				sum += list.get(i);
			}
		}
		return sum;
    }

}
