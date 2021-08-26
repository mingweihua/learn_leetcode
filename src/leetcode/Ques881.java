package leetcode;

import java.util.Arrays;

public class Ques881 {

	public static void main(String[] args) {
		
	}

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int n = people.length;
		int res = 0;
		int right = n-1;
		int left = 0;
		while (right>left){
			if(people[right] + people[left]>limit){
				res++;
				right--;
			} else {
				res++;
				right--;
				left++;
			}
		}
		if(right == left){
			res++;
		}
		return res;
	}
}
