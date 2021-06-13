package leetcode;

public class Ques1060 {

	public static void main(String[] args) {
		int[] nums = {4,7,9,10};
		int k =3;
		System.out.println(new Ques1060().missingElement1(nums, k));
	}
	
	//O(n)
	public int missingElement(int[] nums, int k) {
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1] +1) {
				continue;
			}
			int temp = nums[i]-nums[i-1]-1;
			if(k-temp>0) {
				k-=temp;
			} else {
				return nums[i-1]+k;
			}
		}
		if(k>0) {
			return nums[nums.length-1]+k;
		}
		return -1;
    }
	
	//O(log(n))
	public int missingElement1(int[] nums, int k) {
		if(nums[nums.length-1]-nums[0]+1 == nums.length) {
			return nums[nums.length-1]+k;
		}
		if(k-(nums[nums.length-1]-nums[0]+1-nums.length)>0) {
			return nums[nums.length-1]+k-(nums[nums.length-1]-nums[0]+1-nums.length);
		}
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		while(left != right -1) {
			mid = left + ((right -left)>>1);
			if(nums[mid] - nums[left] +1-(mid-left+1)<k) {
				k -= nums[mid] - nums[left] +1-(mid-left+1);
				left = mid;
			} else {
				right = mid;
			}
		}
		
		return nums[left] + k;
    }
}
