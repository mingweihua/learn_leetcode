package leetcode;

import java.util.TreeSet;

public class Ques363 {

	public static void main(String[] args) {
		int[][] matrix = {{1,0,1},{0,-2,3}};
		int k = 2;
		System.out.println(maxSumSubmatrix(matrix,k));
	}
	
	//超出内存限制
	//
	public static int maxSumSubmatrix(int[][] matrix, int k) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][][][] dp = new int[m+1][n+1][m+1][n+1];
		
		int res = Integer.MIN_VALUE;
		for(int i1=1;i1<=m;i1++) {
			for(int j1=1;j1<=n;j1++) {
				dp[i1][j1][i1][j1] = matrix[i1-1][j1-1];
				for(int i2=i1;i2<=m;i2++) {
					for(int j2=j1;j2<=n;j2++) {
						dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] 
								- dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
						if(dp[i1][j1][i2][j2] == k) {
							return k;
						}
						if(res< dp[i1][j1][i2][j2]  && dp[i1][j1][i2][j2]<k) {
							res = dp[i1][j1][i2][j2];
						}
					}
				}
			}
		}
		return res;
    }
	
	//优化内存
	public static int maxSumSubmatrix2(int[][] matrix, int k) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][]dp;
		
		int res = Integer.MIN_VALUE;
		for(int i1=1;i1<=m;i1++) {
			for(int j1=1;j1<=n;j1++) {
				dp = new int[m+1][n+1];
				dp[i1][j1] = matrix[i1-1][j1-1];
				for(int i2=i1;i2<=m;i2++) {
					for(int j2=j1;j2<=n;j2++) {
						dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] 
								- dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
						if(dp[i2][j2] == k) {
							return k;
						}
						if(res< dp[i2][j2]  && dp[i2][j2]<k) {
							res = dp[i2][j2];
						}
					}
				}
			}
		}
		return res;
    }
	
	//状态压缩，试想遍历上下边界，把一个多维问题变成一个一维（低维）问题
	public static int maxSumSubmatrix3(int[][] matrix, int k) {
		
		int m = matrix.length;
		int n = matrix[0].length;

		int res = Integer.MIN_VALUE;
		//该数值用来存储上下边界中某一列的和，因此矩形中的数值和相当于Sr - Sl(rowSum[l] + rowSum[l+1]...rowSum[r])，
		//问题从一个多维问题转化成一维问题；
		int[] rowSum; 
		for(int i1=0;i1<m;i1++) {
			rowSum = new int[n];
			for(int i2=i1;i2<m;i2++) {
				for(int j=0;j<n;j++) {
					//rowSum[j] += matrix[i2][j];
					/*
					 * (rowSum[l] + rowSum[l+1]...rowSum[r])这样的问题相当于求解最大子序和，因此这样的话暴力解还是需要o(m*m)
					 * 算上外面两层循环还是o(n*n*m*m)
					 */
					//通过前缀和进行压缩
					rowSum[j] += matrix[i2][j];
				}
				int re = dpmax(rowSum,k);
				if(re == k) {
					return k;
				}
				res = Math.max(res, re);
				
				//前缀和数组
				/*
				 * int[] preSum = new int[n+1]; for(int j=1;j<=n;j++) { preSum[j] = preSum[j-1]
				 * + rowSum[j]; }
				 */
				
				/*
				 * Sr - Sl<=k
				 * Sr <= k+sl
				 */
				/*
				 * TreeSet<Integer> sumSet = new TreeSet<Integer>(); sumSet.add(preSum[0]);
				 * for(int j=1;j<=n;j++) { int start = rowSum[j]; }
				 */
	            
			}
		}
		return res;
    }
	
	//状态压缩，试想遍历上下边界，把一个多维问题变成一个一维（低维）问题
	public static int maxSumSubmatrix4(int[][] matrix, int k) {
		int m = matrix.length;
        int n = matrix[0].length;

        int res = Integer.MIN_VALUE;
        //该数值用来存储上下边界中某一列的和，因此矩形中的数值和相当于Sr - Sl(rowSum[l] + rowSum[l+1]...rowSum[r])，
        //问题从一个多维问题转化成一维问题；
        int[] rowSum; 
        for(int i1=0;i1<m;i1++) {
            rowSum = new int[n];
            for(int i2=i1;i2<m;i2++) {
                for(int j=0;j<n;j++) {
                    //rowSum[j] += matrix[i2][j];
                    /*
                        * (rowSum[l] + rowSum[l+1]...rowSum[r])这样的问题相当于求解最大子序和，因此这样的话暴力解还是需要o(m*m)
                        * 算上外面两层循环还是o(n*n*m*m)
                        */
                    //通过前缀和进行压缩
                    rowSum[j] += matrix[i2][j];
                }
                
                //前缀和数组
                
                int[] preSum = new int[n + 1];
                for (int j = 1; j <= n; j++) {
                    preSum[j] = preSum[j - 1] + rowSum[j-1];
                }
                    	                
                /*
                    * Sr - Sl<=k
                    * Sr <= k+sl
                    */
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                for (int j = 1; j <= n; j++) {
                    Integer cur = sumSet.ceiling(preSum[j] - k);
                    if(cur!=null) {
                        res = Math.max(res, preSum[j]-cur);
                    }
                    sumSet.add(preSum[j]);
                }
                
            }
        }
        return res;
    }
	
	
	//前缀数组可以继续优化
	public static int maxSumSubmatrix5(int[][] matrix, int k) {
		int m = matrix.length;
        int n = matrix[0].length;

        int res = Integer.MIN_VALUE;

        int[] rowSum; 
        for(int i1=0;i1<m;i1++) {
            rowSum = new int[n];
            for(int i2=i1;i2<m;i2++) {
                for(int j=0;j<n;j++) {
                    rowSum[j] += matrix[i2][j];
                }
                int sum = 0;
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(sum);
                for (int j = 0; j < n; j++) {
                	sum += rowSum[j];
                    Integer cur = sumSet.ceiling(sum - k);
                    if(cur!=null) {
                        res = Math.max(res, sum-cur);
                    }
                    sumSet.add(sum);
                }
                
            }
        }
        return res;
    }	
	
	// 在数组 arr 中，求不超过 k 的最大值
	private static int dpmax(int[] arr, int k) {
	    // O(rows ^ 2)
	    int max = Integer.MIN_VALUE;
	    for (int l = 0; l < arr.length; l++) {
	        int sum = 0;
	        for (int r = l; r < arr.length; r++) {
	            sum += arr[r];
	            if (sum > max && sum <= k) max = sum;
	        }
	    }
	    return max;
	}
}
