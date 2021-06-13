package leetcode;

public class Ques1011 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int D = 5;
		System.out.println(new Ques1011().shipWithinDays(arr, D));
	}

	public int shipWithinDays(int[] weights, int D) {
		int sum = 0;
		int maxWeight = 0;
		for(int i=0;i<weights.length;i++) {
			sum += weights[i];
			maxWeight = Math.max(maxWeight, weights[i]);
		}
		int mid = 0;
		int res = 0;
		while(maxWeight < sum) {
			mid = maxWeight + ((sum-maxWeight)>>1);
			res = getDays(weights, mid);
			if(res<=D) {
				sum = mid;
			} else {
				maxWeight = mid+1;
			}
		}
		
		return sum;
	
    }
	
	public int getDays(int[] weights, int weightMax) {
		int sum = 0;
		int day = 1;
		for (int i = 0; i < weights.length; i++) {
			if(sum + weights[i] <= weightMax) {
				sum += weights[i];
			} else {
				sum = weights[i];
				day++;
			}
		}
		return day;	
    }
}
