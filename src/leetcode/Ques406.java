package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ques406 {
	
	
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		new Ques406().reconstructQueue(people);
	}
	
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
        int[][] res = new int[people.length][2];
        for(int i=0;i<people.length;i++) {
        	res[i][0] = -1;
        }
        int pre = 0;
    	int pos = 0;   	
        for(int i=0;i<people.length;i++) {
        	pre = people[i][1];
        	pos = 0;
        	while(pos<people.length && pre>=0) {
        		if(pre == 0 && res[pos][0] == -1) {
        			res[pos][0] = people[i][0];
        			res[pos][1] = people[i][1];
        			break;
        		}
        		if(res[pos][0] == -1 || res[pos][0] == people[i][0]) {
        			pre--;
        		}
        		pos++;
        	}
        }
        return res;
    }
	
	
	public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o2[0] - o1[0];
			}
		});
        List<int[]> list = new ArrayList<int[]>();
        for(int i=0;i<people.length;i++) {
        	if(list.size()<=people[i][1]) {
        		list.add(people[i]);
        	} else {
        		list.add(people[i][1],people[i]);
        	}
        }
        
        return list.toArray(new int[people.length][2]);
    }
}
