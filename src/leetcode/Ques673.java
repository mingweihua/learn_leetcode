package leetcode;

public class Ques673 {

	public static void main(String[] args) {
        int[] nums ={1,3,5,4,7,5,6,5,7,8,12};
        System.out.println(new Ques673().findNumberOfLIS(nums));
	}


	//看了答案才会，动态规划，时间复杂度n*n
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        len[0] = 1;
        count[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            len[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    if(len[j]+ 1 > len[i]){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if(len[j]+ 1 == len[i]){
                        count[i] += count[j];
                    }
                }

            }
        }

        int maxLen = 0;
        for (int length : len){
            maxLen = Math.max(maxLen,length);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(len[i] == maxLen){
                res += count[i];
            }
        }
        return res;
    }

    //更优解法，线段树，暂时看不懂，不想看了
    public int findNumberOfLIS2(int[] nums) {
        return 0;
    }
	
}
