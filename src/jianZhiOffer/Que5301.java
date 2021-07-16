package jianZhiOffer;

public class Que5301 {

    public static void main(String[] args) {
        int[] nums = {1,4};
        System.out.println(new Que5301().search(nums,4));
    }


    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0] == target?1:0;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int start = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(nums[mid]<target){
                left = mid +1;
            } else if(nums[mid]==target){
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if(nums[left]!=target){
            return 0;
        }
        start = left;
        if(left+1 >= nums.length || nums[left+1]!=target){
            return 1;
        }
        right = nums.length -1 ;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(nums[mid]<target+1){
                left = mid +1;
            } else if(nums[mid]==target+1){
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if(nums[left] == target){
            return left - start+1;
        }
        return left - start;
    }
}
