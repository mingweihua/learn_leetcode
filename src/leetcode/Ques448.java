package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ques448 {
	
	
	public static void main(String[] args) {
		
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new LinkedList<Integer>();
		int i =0;
		while(i<nums.length) {
			if(nums[i] == i+1 || nums[nums[i]-1] == nums[i]) {
				i++;
				continue;
			}
			int temp = nums[nums[i]-1];
			nums[nums[i]-1] = nums[i];
			nums[i] = temp;
		}
		
		for(int j=0;j<nums.length;j++) {
			if(nums[j] == j+1) {
				continue;
			}	
			res.add(j+1);
		}
		return res;
    }
	
	/*力扣方法，更加完善*/
	public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
