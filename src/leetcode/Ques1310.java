package leetcode;

public class Ques1310 {

	public static void main(String[] args) {
		int[] arr = {16};
		int[][] queries = {{0,0},{0,0},{0,0}};
		System.out.println(new Ques1310().xorQueries(arr, queries));
	}
	
	
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] dp = new int[arr.length+1];
		for(int i=1;i<=arr.length;i++) {
			dp[i] = arr[i-1] ^ dp[i-1];
		}
		int[] res = new int[queries.length];
		for(int i=0;i<queries.length;i++) {
			if(queries[i][0] == queries[i][1]) {
				res[i] = arr[queries[i][0]];
			} else {
				res[i] = dp[queries[i][0]] ^ dp[queries[i][1]+1];
			}
		}
		
		return res;
    }
}
