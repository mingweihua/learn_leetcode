package leetcode;
import java.util.HashMap;

public class Ques477 {
	
	
	public static void main(String[] args) {
		
	}
	

	//超时了
	public int totalHammingDistance(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int temp = 0;
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				temp = nums[i] ^ nums[j];
				map.put(temp, map.getOrDefault(temp, 0)+1);
			}
		}
		for (Integer key : map.keySet()) {
			res += (totalHammingDistance(key) * map.get(key));
		}
		return res;
    }
	
	
	public int totalHammingDistance(int n) {
		int res = 0;
		while(n != 0) {
			res += (n & 1);
			n = (n>>>1);
		}
		return res;
    }
	
	public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

}
