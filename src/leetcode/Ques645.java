package leetcode;


public class Ques645 {

    public static void main(String[] args) {

    }

    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];
        int[] dp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
			dp[nums[i]]++;
			if(dp[nums[i]] == 2){
				res[0] = nums[i];
			}
        }
		for (int i = 1; i < dp.length; i++) {
			if(dp[i] == 0){
				res[1] = i;
			}
		}


        return res;
    }
}
