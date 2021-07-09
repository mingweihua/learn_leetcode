package baodian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ques1710 {

    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == res){
                times++;
            } else {
                if(times<=1){
                    res = nums[i];
                    times = 1;
                } else {
                    times--;
                }
            }
        }
        if(times> nums.length/2){
            return res;
        }
        times = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == res){
                times++;
            }
        }
        return times>nums.length/2?res:-1;

    }
}
