package leetcode;

public class Ques72 {

	public static void main(String[] args) {
		
	}


	//编辑距离，看答案才会
	//编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
	public int minDistance(String word1, String word2) {
		if(word1==null && word2 == null) {
			return 0;
		}
		if(word1.length()==0 && word2.length()==0) {
			return 0;
		}
		int m = word1.length();
		int n = word2.length();
		int[][] M = new int[m+1][n+1];
		for (int i = 0; i < m+1; i++) {
			M[i][0] = i;
		}
		for (int i = 1; i < n+1; i++) {
			M[0][i] = i;
		}
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					M[i][j] = 1+ Math.min(M[i][j-1], Math.min(M[i-1][j], M[i-1][j-1]-1));
				} else {
					M[i][j] = 1+ Math.min(M[i][j-1], Math.min(M[i-1][j], M[i-1][j-1]));
				}
			}
		}
		return M[m][n];		
    }
}
