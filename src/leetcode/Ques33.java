package leetcode;

public class Ques33 {

	public static void main(String[] args) {
		int[] a = {3,1};
		System.out.println(new Ques33().search(a,1));
	}
	
	public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        int first = 0;
        int last = nums.length-1;
        int mid;
        while(first < last){
            mid = first + ((last - first) >> 1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[first] <= nums[mid]){
               //左半区域单调递增
               if(target>=nums[first] && target<=nums[mid]){
                   //值即使出现必在左区域
                   last = mid-1;
               } else {
                   first = mid+1;
               }
            } else {
                //右半区域递增
                if(target>=nums[mid] && target<=nums[last]){
                   //值即使出现必在右区域
                    first = mid+1;
               } else {
                   last = mid-1;
               }

            }
        }

        if(nums[first] == target){
            return first;
        } else {
            return -1;
        }
    }

}
