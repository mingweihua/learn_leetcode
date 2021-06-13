package leetcode;

import java.util.HashSet;

public class Ques287 {
	

	public static void main(String[] args) {
		int[] arr = {1,3,4,3,3};
		System.out.println(new Ques287().findDuplicate2(arr));
	}
	
	
	public int findDuplicate(int[] nums) {      
		HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
        	if (set.contains(nums[i])) {
				return nums[i];
			} else {
				set.add(nums[i]);
			}
        }
        return 0;
    }
	
	public int findDuplicate2(int[] nums) {      
        for(int i=0;i<nums.length;i++){
        	if(nums[i] == i+1) {
        		continue;
        	}
        	
        	if(nums[nums[i]-1] == nums[i]) {
        		return nums[i];
        	} else {
        		int temp = nums[nums[i]-1];
        		nums[nums[i]-1] = nums[i];
        		nums[i] = temp;
        		i--;
        	}
        }
        return 0;
    }
}