package test.bigo;

public class Main3 {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{6,5,1},{4,2,1}};
        System.out.println(new Main3().maximumGiftValue(grid));
    }

    public int maximumGiftValue(int[][] grid){
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][n-1];
    }

}
