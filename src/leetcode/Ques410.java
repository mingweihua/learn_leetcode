package leetcode;

public class Ques410 {
	
	
	public static void main(String[] args) {

	}

    public int splitArray(int[] nums, int m) {
	    int left = 0;
	    int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            left = Math.max(left,nums[i]);
        }

        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(check(nums,mid,m)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public boolean check(int[] nums, int max, int m){
	    int cur = 1;
	    int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i] <= max){
                sum += nums[i];
            } else {
                sum = nums[i];
                cur++;
            }
        }
        return cur <= m;
    }
}
