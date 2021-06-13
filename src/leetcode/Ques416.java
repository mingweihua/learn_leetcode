package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ques416 {
	
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 11, 5};
		System.out.println(new Ques416().canPartition(arr));
	}
	
	public boolean canPartition(int[] nums) {
        if(nums.length<=1){
            return false;
        }
        if(nums.length == 2){
            return nums[0] == nums[1];
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum /= 2;
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> list;
        set.add(sum);
        for(int i=0;i<nums.length;i++) {
        	if(set.contains(nums[i])) {
        		return true;
        	} else {
        		list = new ArrayList<Integer>(set.size());
        		for(Integer t:set) {
        			if(t-nums[i]>0) {
        				list.add(t-nums[i]);
        			}
        		}
        		set.addAll(list);
        	}
        }
		return false;
    }
	
	public boolean canPartition2(int[] nums) {
        if(nums.length<=1){
            return false;
        }
        if(nums.length == 2){
            return nums[0] == nums[1];
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        for(int i=0;i<dp.length;i++) {
        	dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i=1;i<dp.length;i++) {
        	for(int j=1;j<dp[0].length;j++) {
        		if(nums[i]>sum) {
        			return false;
        		}
        		if(nums[i]<=j) {
        			dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
        		} else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
		return dp[nums.length-1][sum];
    }
}
