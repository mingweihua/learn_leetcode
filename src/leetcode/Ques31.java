package leetcode;

import java.util.Arrays;

public class Ques31 {

	public static void main(String[] args) {

	}
	
	
	public void nextPermutation(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        int start=nums.length-2;
        while(start>=0){
            if(nums[start] < nums[start+1]){
                break;
            }
            start--;
        }
        if(start==-1){
            Arrays.sort(nums);
            return;
        }
        if(start==nums.length-2){
            swap(nums,start,nums.length-1);
            return;
        }
        Arrays.sort(nums,start+1,nums.length);
        for(int i=start+1;i<nums.length;i++) {
        	if(nums[i]>nums[start]) {
        		swap(nums,start,i);
        		return;
        	}
        }
    }
	
	public void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
