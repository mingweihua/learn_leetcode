package leetcode;

import java.util.Stack;

public class Ques456 {
	
	
	public static void main(String[] args) {
		int[] arr = {3,1,4,2};
		System.out.println(new Ques456().find132pattern(arr));
	}
	
	public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums[nums.length-1]);
        int rightMax = Integer.MIN_VALUE;
        
        for(int i=nums.length-2;i>=0;i--) {
        	if(nums[i]<rightMax) {
        		return true;
        	}
        	while(!stack.isEmpty() && nums[i]>stack.peek()) {
        		rightMax = stack.pop();
        	}
        	if(nums[i]>rightMax) {
        		stack.push(nums[i]);
        	}
        }
        return false;
    }
}
