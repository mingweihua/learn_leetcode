package leetcode;

public class Ques1588 {

	public static void main(String[] args) {

	}


	//前缀，时间复杂度是n*n
	public int sumOddLengthSubarrays(int[] arr) {
		int[] pre = new int[arr.length+1];
		for (int i = 1; i <= arr.length; i++) {
			pre[i] = pre[i-1] + arr[i-1];
		}
		int res = pre[arr.length];
		for (int i = 3; i <= arr.length; i += 2) {
			for (int j = 0; j <= arr.length-i ; j++) {
				res += (pre[j+i] - pre[j]);
			}
		}
		return res;
	}


	//数学方法，复杂度是n，有兴趣看Leetcode答案，前缀已经够了，笔试时间复杂度不会限制那么严


}
