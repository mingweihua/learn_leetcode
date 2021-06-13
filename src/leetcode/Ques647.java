package leetcode;


public class Ques647 {

	public static void main(String[] args) {
		
	}
	
	public int countSubstrings(String s) {
		
		boolean[][] check = new boolean[s.length()][s.length()];
		for (int i = 0; i < check.length; i++) {
			check[i][i] = true;
		}
		for (int i = check.length-1; i >= 0; i--) {
			for (int j = i; j < check[0].length; j++) {
				if(i == j) {
					check[i][j] = true;
				} else if (j == i+1) {
					check[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					check[i][j] = check[i+1][j-1] && (s.charAt(i) == s.charAt(j));
				}				
			}
		}
		
		
		int[][] dp = new int[s.length()][s.length()];
		
		for (int i = dp.length-1; i >= 0; i--) {
			for (int j = i; j < dp[0].length; j++) {
				if(i == j) {
					dp[i][j] = 1;
				}  else {
					dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + (check[i][j]?1:0);
				}				
			}
		}
		return dp[0][s.length()-1];
    }
	
	//优化上述方法的空间
	public int countSubstrings2(String s) {
		int res = 0;
		boolean[][] check = new boolean[s.length()][s.length()];
		for (int i = 0; i < check.length; i++) {
			check[i][i] = true;
		}
		for (int i = check.length-1; i >= 0; i--) {
			for (int j = i; j < check[0].length; j++) {
				if(i == j) {
					check[i][j] = true;
				} else if (j == i+1) {
					check[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					check[i][j] = check[i+1][j-1] && (s.charAt(i) == s.charAt(j));
				}	
				if(check[i][j]) {
					res++;
				}
			}
		}
		
		return res;
    }
}
