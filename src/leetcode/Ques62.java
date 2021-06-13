package leetcode;

public class Ques62 {

	public static void main(String[] args) {
		
	}
	
	//使用深度搜索，超时了
	public int uniquePaths1(int m, int n) {
        if(m < 1 || n<1){
            return 0;
        }
        dps(m, n, 1, 1);
        return num;
    }

    int num = 0;
    public void dps(int m, int n, int i, int j){
        if(i == m && j == n){
            num++;
            return;
        }
        if(i != m){
            dps(m,n,i+1,j);
        }
        if(j != n){
            dps(m,n,i,j+1);
        }
    }
	
    
    //动态规划,时间复杂度O(mn)
    public int uniquePaths(int m, int n) {
        if(m < 1 || n<1){
            return 0;
        }
        int[][] M = new int[m+1][n+1];
        for(int j=1;j<=n;j++) {
        	M[1][j] = 1;
        }
        
        for (int i=2;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		M[i][j] = M[i-1][j] + M[i][j-1];
        	}
        }
        return M[m][n];
    }
    
    /**
     * 从左上角到右下角的过程中，我们需要移动 m+n-2m+n−2 次，其中有 m-1m−1 次向下移动，n-1n−1 次向右移动。因
     * 
     * 此路径的总数，就等于从 m+n-2m+n−2 次移动中选择 m-1m−1 次向下移动的方案数，即组合数：
     *
​ 
     */
  //动态规划,时间复杂度O(min(m,n))
    public int uniquePaths2(int m, int n) {
    	if(m < 1 || n<1){
            return 0;
        }
    	long ans=1;

    	for(int i=1,j=n;i<=m-1;i++,j++) {
    		ans = ans*j/i;
    	}
		return (int)ans;
    }
}
