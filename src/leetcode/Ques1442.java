package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Ques1442 {

	
	//这是两层循环
	public int countTriplets(int[] arr) {
		
		int[] dp = new int[arr.length+1];
		for(int i=1;i<arr.length+1;i++) {
			dp[i] = dp[i-1] ^ arr[i-1];
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(0);
		map.put(dp[0], one);
		ArrayList<Integer> temp = null;
		int res = 0;
		for(int i=1;i<arr.length+1;i++) {
			if(map.containsKey(dp[i])) {
				temp = map.get(dp[i]);
				for(int j=0;j<temp.size();j++) {
					if(i-temp.get(j)<2) {
						break;
					}
					res += (i-temp.get(j)-1);
				}
				temp.add(i);
			} else {
				one = new ArrayList<Integer>();
				one.add(i);
				map.put(dp[i], one);
			}
		}
		return res;
    }
	
	
	//可以优化map。变成一层循环
	public int countTriplets2(int[] arr) {
		
		int[] dp = new int[arr.length+1];
		for(int i=1;i<arr.length+1;i++) {
			dp[i] = dp[i-1] ^ arr[i-1];
		}
		HashMap<Integer, Integer> map_size = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map_sum = new HashMap<Integer, Integer>();
		map_size.put(dp[0], 1);
		map_sum.put(dp[0], 0);
		int res = 0;

		for(int i=1;i<arr.length+1;i++) {
			if(map_size.containsKey(dp[i])) {
				res += (map_size.get(dp[i]) * i - map_sum.get(dp[i]) - map_size.get(dp[i]));
			}
			map_size.put(dp[i], map_size.getOrDefault(dp[i], 0)+1);
			map_sum.put(dp[i], map_sum.getOrDefault(dp[i], 0)+i);
		}
		return res;
    }
}
