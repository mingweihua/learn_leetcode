package key.uglyNumber;


public class NthSuperUglyNumber {

	public static void main(String[] args) {

		int n = 12;
		int[] primes = {2,7,13,19};
		System.out.println(new NthSuperUglyNumber().nthSuperUglyNumber(n,primes));
	}

	/*
		对应leetcode的313题目
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(n == 1){
			return 1;
		}
		int[] res = new int[n];
		res[0] = 1;
		int[] points = new int[primes.length];
		int temp = 0;
		for (int i = 1; i < n ; i++) {
			res[i] = Integer.MAX_VALUE;
			for (int j = 0; j < points.length; j++) {
				res[i] = Math.min(res[i],res[points[j]] * primes[j]);
			}

			for (int j = 0; j < points.length; j++) {
				if(res[i] == res[points[j]] * primes[j]){
					points[j]++;
				}
			}
		}
		return res[n-1];
	}
	
}
