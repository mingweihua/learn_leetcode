package leetcode;

import java.util.Stack;

public class Ques84 {

	public static void main(String[] args) {
		int[] arr = {2,1,5,6,2,3};
		new Ques84().largestRectangleArea(arr);
	}
	
	
	//暴力解法，固定高度 
	public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i=0;i<heights.length;i++) {
        	left = i-1;
        	while(left>-1 && heights[left] >= heights[i]) {
        		left--;
        	}
        	right = i+1;
        	while(right<heights.length && heights[right] >= heights[i]) {
        		right++;
        	}
        	max = Math.max(max, (right-left-1)*heights[i]);
        }
        return max;
    }
	
	//根据上面的固定高度的思想，通过单调栈求解
	public int largestRectangleArea2(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int height = 0;
        for(int i=0;i<heights.length;i++) {
        	while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        		height = heights[stack.pop()];
        		if(!stack.isEmpty()) {
        			max = Math.max(max, (i-stack.peek()-1)*height);
        		} else {
        			max = Math.max(max, (i+1-1)*height);
        		}  		
        	}
        	stack.push(i);
        }
        while(!stack.isEmpty()) {
        	height = heights[stack.pop()];
        	if(!stack.isEmpty()) {
    			max = Math.max(max, (heights.length-stack.peek()-1)*height);
    		} else {
    			max = Math.max(max, (heights.length+1-1)*height);
    		} 
        }
        return max;
    }

}
