package leetcode;


public class Ques1894 {

	public static void main(String[] args) {

	}

	public int chalkReplacer(int[] chalk, int k) {
		long[] pre = new long[chalk.length];
		pre[0] = chalk[0];
		for (int i = 1; i < chalk.length; i++) {
			pre[i] = pre[i-1] + chalk[i];
		}
		long target = (k % pre[pre.length-1]);
		if(target<chalk[0]){
			return 0;
		}
		int left = 0;
		int right = pre.length-1;
		int mid = 0;
		while (left<right){
			mid = left+((right-left)>>1);
			if (target<pre[mid]){
				right = mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}

}
