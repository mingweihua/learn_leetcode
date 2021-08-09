package leetcode;


public class Ques313 {

	public static void main(String[] args) {

		int n = 12;
		int[] primes = {2,7,13,19};
		System.out.println(new Ques313().nthSuperUglyNumber(n,primes));
	}


	public int nthSuperUglyNumber(int n, int[] primes) {
		if(n == 1){
			return 1;
		}
		int[] res = new int[n];
		res[0] = 1;


		int[] temp;
		for (int i = 1; i < n ; i++) {

		}
		return res[n-1];
	}
	
}
