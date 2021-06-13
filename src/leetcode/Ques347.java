package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ques347 {

	public static void main(String[] args) {
		
	}
	
	 public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }  
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] o1, int[] o2) -> {
        	return o1[1] - o2[1]; 
        });
        for(Map.Entry<Integer, Integer> ele : map.entrySet()) {
        	int[] arr = new int[2];
    		arr[0] = ele.getKey();
    		arr[1] = ele.getValue();
    		queue.add(arr);
        	if(queue.size()>k) {
        		queue.remove();
        	}
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
        	res[i] = queue.remove()[0];
        }
		return res;    
    }
}
