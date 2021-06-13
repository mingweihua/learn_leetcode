package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ques253 {

	public static void main(String[] args) {
		
	}
	
	//时间复杂度是n*n,因为下一个会议开始都要遍历一下list中有哪个会议室是空的，其实可以通过优先队列来优化（leetcode答案）
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> one = new ArrayList<int[]>();
		one.add(intervals[0]);
		list.add(one);
		int classNum = 0;
		for(int i=1;i<intervals.length;i++) {
			classNum = 0;
			while(classNum<list.size() && 
					intervals[i][0] < list.get(classNum).get(list.get(classNum).size()-1)[1]) {
				classNum++;			
			}
			if(classNum == list.size()) {
				one = new ArrayList<int[]>();
				one.add(intervals[i]);
				list.add(one);
			} else {
				list.get(classNum).add(intervals[i]);
			}
		}
		return list.size();  
    }
	
	
	
	public int minMeetingRooms2(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(intervals[0][1]);
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][0] >= queue.peek()) {
				queue.poll();
			}
			
			queue.add(intervals[i][1]);
		}
		
		return queue.size();  
    }
}
