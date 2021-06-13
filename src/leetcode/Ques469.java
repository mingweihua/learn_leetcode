package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques469 {
	
	
	public static void main(String[] args) {
		int[][] arr = {{0,0},{0,1},{1,1},{1,0}};
		List<List<Integer>> points = new ArrayList<List<Integer>>(); 
		for(int i=0;i<arr.length;i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(arr[i][0]);
			list.add(arr[i][1]);
			points.add(list);
		}
		
		System.out.println(new Ques469().isConvex2(points));
	}
	
	
	//超出时间限制
	public boolean isConvex(List<List<Integer>> points) {
		if(points.size()<3) {
			return false;
		}
		if(points.size() == 3) {
			return true;
		}
		int n = points.size();
		int point2 = 0;
        int test = 0;
		for(int i=0;i<n;i++) {
			point2 = (i+2) % n;
            test = (i+1) % n;
			if(!isConvex(points.get(i),points.get(point2)
					,points.get(test),points)) {
				return false;
			}
		}
		
		return true;
    }
	
	public boolean isConvex(List<Integer> point1,List<Integer> point2,List<Integer> test,List<List<Integer>> points) {
		double A = 0.0;
		double B = 0.0;
		double t1 = 0.0;
		double t2 = 0.0;
		boolean sec = true;
		if(point2.get(0) - point1.get(0) != 0) {
			A = (point2.get(1) - point1.get(1)) / (double)(point2.get(0) - point1.get(0));
			B = point2.get(1) - A * point2.get(0);	
			t1 = test.get(1) - (A * test.get(0) + B);
			sec = true;
		} else {
			t1 = test.get(0) - point2.get(0);
			sec = false;
		}
		
		for(int i=0;i<points.size();i++) {
			if(points.get(i) == point1) {
				continue;
			}
			if(points.get(i) == point2) {
				continue;
			}
			if(points.get(i) == test) {
				continue;
			}
			if(sec) {
				t2 = points.get(i).get(1) - (A * points.get(i).get(0) + B);
			} else {
				t2 = points.get(i).get(0) - point2.get(0);
			}
			if(t1*t2>0) {
				return false;
			}
		}
		
		return true;
	}
	
	

	
	public boolean isConvex2(List<List<Integer>> points) {
		if(points.size()<3) {
			return false;
		}
		if(points.size() == 3) {
			return true;
		}
		int x1,y1,x2,y2;
		long pre = 0;
        long cur = 0;
		int n = points.size();
		for(int i=0;i<n;i++) {
			x1 = points.get((i+1) % n).get(0) - points.get(i).get(0);
			y1 = points.get((i+1) % n).get(1) - points.get(i).get(1);
			
			x2 = points.get((i+2) % n).get(0) - points.get(i).get(0);
			y2 = points.get((i+2) % n).get(1) - points.get(i).get(1);
			
			cur = x1*y2 - x2*y1;
			
			if(cur != 0) {
				if(cur * pre < 0) {
					return false;
				}
				pre = cur;
			}
			
		}
		
		return true;
	}
	

}
