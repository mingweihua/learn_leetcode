package leetcode;


public class Ques213 {

	public static void main(String[] args) {
		int[] arr = {2,2,4,3,2,5};
		System.out.println(new Ques213().rob(arr));	
	}

	public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp1 = new int[nums.length];
        boolean[] flag = new boolean[nums.length];
        dp1[0] = 0;
        dp[0] = nums[0];
        flag[0] = true;
        if(nums[0]>nums[1]){
            dp[1] = nums[0];
            flag[1] = true;
        } else {
            dp[1] = nums[1];
            flag[1] = false;
        }  
        dp1[1] = nums[1];
        for(int i=2;i<nums.length;i++){
        	dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
            if(dp[i-1]>=dp[i-2]+nums[i]){
                dp[i] = dp[i-1];
                flag[i] = flag[i-1];
            } else {
                if(i==nums.length-1 && flag[i-2]){
                   dp[i] = Math.max(dp1[i-2]+nums[i],Math.max(dp[i-1],dp[i-2])); 
                } else {
                    dp[i] = dp[i-2]+nums[i];
                }
                flag[i] = flag[i-2];
            }     
        }
        return dp[nums.length-1];
    }
	
	//初步优化动态规划方法的空间
	public int rob2(int[] nums) {
		if(nums.length==1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], nums[0]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i=2;i<nums.length;i++) {
        	dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        	dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        if(dp1[nums.length-1] == dp2[nums.length-1]) {
        	return dp1[nums.length-1];
        } else {
        	int result = 0;
        	if(nums.length-3>=0) {
        		result = Math.max(dp2[nums.length-1],Math.max(dp1[nums.length-2], dp1[nums.length-3]));
        	} else {
                result = Math.max(dp2[nums.length-1],dp1[nums.length-2]);
            }
        	return result;
        }
    }
	
	//进一步优化动态规划方法的空间
	public int rob3(int[] nums) {
		if(nums.length==1){
            return nums[0];
        }
		int dp1_a = nums[0];
		int dp1_b = Math.max(nums[1], nums[0]);
		int dp2_a = 0;
		int dp2_b = nums[1];
		int dp1_c = dp1_b;
        int dp2_c = dp2_b;
        for(int i=2;i<nums.length;i++) {
        	dp1_c = Math.max(dp1_b,dp1_a+nums[i]);
        	dp2_c = Math.max(dp2_b,dp2_a+nums[i]);
        	if(i!=nums.length-1) {
        		dp1_a = dp1_b;
            	dp1_b = dp1_c;
            	dp2_a = dp2_b;
            	dp2_b = dp2_c;
        	}	
        }
        if(dp1_c == dp2_c) {
        	return dp1_c;
        } else { 	
        	return Math.max(dp2_c,Math.max(dp1_b, dp1_a));
        }
    }
}