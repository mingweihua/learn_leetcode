package leetcode;

public class Ques152 {

	public static void main(String[] args) {
		
	}
	
	//自己想的动态规划，但是最后一些案例会报内存超出限制
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[][] s = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            s[i][i] = nums[i];
        }
        int max = s[nums.length-1][nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            max = Math.max(max,s[i][i]);
            for(int j=i+1;j<nums.length;j++){
                s[i][j] = s[i][i] * s[i+1][j];
                max = Math.max(max,s[i][j]);
            }
        }
        return max;
    }
	
	//经分析只要保存上一次计算的值即可，不需要O(n*n)的空间复杂度
	public int maxProduct2(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        int max = dp[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                dp[j] = dp[j]*nums[i];
                max = Math.max(max,dp[j]);
            }
            dp[i] =nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
	
	//官方答案，也是我未完成的思路之一，正负分开考虑
	public int maxProduct3(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int max = maxF[0];
        for(int i=1;i<nums.length;i++) {
        	maxF[i] = Math.max(nums[i],Math.max(nums[i]*maxF[i-1], nums[i]*minF[i-1]));
        	minF[i] = Math.min(nums[i],Math.min(nums[i]*maxF[i-1], nums[i]*minF[i-1]));
        	max = Math.max(max,maxF[i]);
        }
        
        return max;
    }
	
	//官方答案，优化空间复杂度，因为某一次的计算只与上次的计算相关，只要保留上一次的计算结果即可
	public int maxProduct4(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int maxF = nums[0];
        int minF = nums[0];
        int max = maxF;
        int temp;
        for(int i=1;i<nums.length;i++) {
        	temp = Math.max(nums[i],Math.max(nums[i]*maxF, nums[i]*minF));
        	minF = Math.min(nums[i],Math.min(nums[i]*maxF, nums[i]*minF));
        	maxF = temp;
        	max = Math.max(max,maxF);
        }
        
        return max;
    }
}
