package leetcode;

import java.util.Stack;

public class Ques42 {
	
	
	public static void main(String[] args) {
		int[] arr = {9,6,8,8,5,6,3};
		System.out.println(new Ques42().trap(arr));
	}
	
	//暴力解法
	public int trap(int[] height) {
        if(height.length <=2) {
			return 0;
		}
        int left_max;
        int right_max;
        int sum = 0;
		for(int i=1;i<height.length;i++){
            left_max = height[i];
            right_max = height[i];
            for(int j=i-1;j>=0;j--){
                left_max = Math.max(height[j],left_max);
            }

            for(int j=i+1;j<height.length;j++){
                right_max = Math.max(height[j],right_max);
            }

            sum += Math.min(left_max,right_max) - height[i];
        }
        return sum;
    }
	
	//动态规划解法
	public int trap2(int[] height) {
        if(height.length <=2) {
			return 0;
		}
        int size = height.length;
        int[] left_max_arr = new int[size];
        int[] right_max_arr = new int[size];
        int sum = 0;

        left_max_arr[0] = height[0];//初始条件
		for(int i=1;i<size;i++){
            left_max_arr[i] = Math.max(left_max_arr[i-1], height[i]);
        }

        right_max_arr[size-1] = height[size-1];//初始条件
		for(int i=size-2;i>=0;i--){
            right_max_arr[i] = Math.max(right_max_arr[i+1], height[i]);
        }

        for(int i=0;i<size;i++){
           sum += Math.min(left_max_arr[i], right_max_arr[i]) - height[i];
        }

        return sum;
    }
	
	//双指针解法
	public int trap3(int[] height) {
        if(height.length <=2) {
			return 0;
		}
        int left = 0;
        int right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        int sum = 0;
        while(left<right){
            if(height[left] < height[right]){
                left_max = Math.max(left_max,height[left]);
                sum += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max,height[right]);
                sum += right_max - height[right];
                right--;
            }
        }
        return sum;  
    }
	
	//单调递减栈法
	public int trap4(int[] height) {
		if(height.length <=2) {
			return 0;
		}
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        for(int i=0;i<height.length;i++){
            //产生积水的位置是低洼处，也就是此位置的高度比前一个位置高度要大
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int lastIndex = stack.pop();
                if(!stack.isEmpty()){
                    //横向积水高度
                    int hei = Math.min(height[stack.peek()],height[i]) - height[lastIndex];
                    //横向积水宽度
                    int distance = i - stack.peek() - 1;
                    sum += (distance*hei);
                }      
            }
            stack.push(i);
        }
        return sum;  
    }
}
