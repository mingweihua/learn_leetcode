package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.List;

public class Ques56 {

	public static void main(String[] args) {
		int[][] test = {{2,3},{5,5},{2,2},{3,4},{3,4}};
		int[][] res = new Ques56().merge(test);
		System.out.println("结果是：");
		PrintArray.print2DArray(res);
	}
	
	
	
	public int[][] merge(int[][] intervals) {
		
		/*Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] - o2[0] == 0) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});*/
		
		Arrays.sort(intervals,(o1,o2) -> {
			if(o1[0] - o2[0] == 0) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		PrintArray.print2DArray(intervals);
        int nums = intervals.length;
        List<int[]> list = Arrays.asList(intervals);
        ArrayList<int[]> intervals_list = new ArrayList<int[]>(list);
        for(int i=1;i<nums;i++){
        	if(intervals_list.get(i)[0] <= intervals_list.get(i-1)[1]) {
        		if(intervals_list.get(i)[0]<=intervals_list.get(i-1)[0]) {
        			intervals_list.remove(i-1);
        			i--;
        			nums--;
        		} else {
        			intervals_list.get(i-1)[1] = Math.max(intervals_list.get(i-1)[1],intervals_list.get(i)[1]);
        			intervals_list.remove(i);
        			i--;
        			nums--;
        		}
        	}
        }
        int[][] res = new int[nums][2];
        intervals_list.toArray(res);
		return res;
    }

}
