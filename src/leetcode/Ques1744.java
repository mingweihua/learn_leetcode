package leetcode;


public class Ques1744 {

	public static void main(String[] args) {
		
	}

	public boolean[] canEat(int[] candiesCount, int[][] queries) {
		long[] pre = new long[candiesCount.length+1];
		boolean[] res = new boolean[queries.length];
		for (int i = 1; i < pre.length; i++) {
			pre[i] = pre[i-1] + candiesCount[i-1];
		}
		int favoriteType = 0;
		int favoriteDay = 0;
		int dailyCap = 0;
		for (int i = 0; i < res.length; i++) {
			favoriteType = queries[i][0];
			favoriteDay = queries[i][1];
			dailyCap = queries[i][2];
			
			long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = pre[favoriteType] + 1;
            long y2 = pre[favoriteType+1];

			
            res[i] = !(x1 > y2 || y1 < x2);

		}
		return res;
    }

}
