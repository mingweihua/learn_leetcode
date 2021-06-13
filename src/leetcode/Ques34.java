package leetcode;


public class Ques34 {

	public static void main(String[] args) {
		int[] arr = {3,3,3};
		int[] res = new Ques34().searchRange(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 1 && nums[0] == target){
            return res;
        }
        res[0] = -1;
        res[1] = -1;
        if(nums.length == 0){
            return res;
        }
        int first = 0;
        int end = nums.length - 1;
        int mid;
        int firstIndex = -1;
        while(first <= end){
            mid = first + ((end-first)>>1);
            if(nums[mid] == target){
                firstIndex = mid;
                end = mid - 1;
            } else if(nums[mid] > target){
            	end = mid -1;            
            } else {
            	first = mid+1;
            }
        }
        if(firstIndex != -1){
            res[0] = firstIndex;

            first = firstIndex+1;
            end = nums.length - 1; 
            while(first<=end){
                mid = first + ((end-first)>>1);
                if(nums[mid] == target){
                    firstIndex = mid;
                    first = mid + 1;
                } else if(nums[mid] > target){
                	end = mid -1;            
                } else {
                	first = mid+1;
                }
            }
            res[1] = firstIndex;
        }

        return res;
    }
}
