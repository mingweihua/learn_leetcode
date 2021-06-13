package leetcode;

public class Ques238 {

	public static void main(String[] args) {

	}
	
	public int[] productExceptSelf(int[] nums) {
		int[] pre = new int[nums.length];
		pre[0] = 1;
		int[] after = new int[nums.length];
		after[nums.length-1] = 1;
		for (int i = 1; i < nums.length; i++) {
			pre[i] = pre[i-1] * nums[i-1];
			after[nums.length-1-i] = after[nums.length-i] * nums[nums.length-i];
		}
		int[] res = new int[nums.length];
		res[0] = after[0];
		res[nums.length-1] = pre[nums.length-1];
		for(int i = 1; i < nums.length-1; i++) {
			res[i] = after[i] * pre[i];
		}
		return res;
    }
	
	//优化空间复杂度
	public int[] productExceptSelf2(int[] nums) {
		int pre = 1;
		int[] after = new int[nums.length];
		after[nums.length-1] = 1;
		for (int i = 1; i < nums.length; i++) {
			after[nums.length-1-i] = after[nums.length-i] * nums[nums.length-i];
		}
		int[] res = new int[nums.length];
		res[0] = after[0] * pre;
		for(int i = 1; i < nums.length; i++) {
			pre *= nums[i-1];
			res[i] = after[i] * pre;
		}
		return res;
    }
	
	//优化空间复杂度
	public int[] productExceptSelf3(int[] nums) {
		int pre = 1;
		int[] res = new int[nums.length];
		res[nums.length-1] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[nums.length-1-i] = res[nums.length-i] * nums[nums.length-i];
		}
		res[0] *= pre;
		for(int i = 1; i < nums.length; i++) {
			pre *= nums[i-1];
			res[i] *= pre;
		}
		return res;
    }
}
