package leetcode;

public class Ques240 {

	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 25;
		System.out.println(new Ques240().searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		if(target < matrix[0][0] || target > matrix[n-1][m-1]) {
			return false;
		}
		int left = 0;
		int right = 0;
		int mid = 0;
		
		//确定下界
		left = 0;
		right = n-1;
		while(left<right && matrix[right][0] > target) {
			mid = left + ((right-left)>>1);
			if(matrix[mid][0] == target) {
				return true;
			} else if(matrix[mid][0] > target) {
				right = mid -1;
			} else {
				left =  mid+1;
			}
		}
		int row_e = right;
		
		//确定上界
		left = 0;
		right = row_e;
		while(left<right && matrix[left][m-1] < target) {
			mid = left + ((right-left)>>1);
			if(matrix[mid][m-1] == target) {
				return true;
			} else if(matrix[mid][m-1] < target) {
				left = mid + 1;
			} else {
				right = mid-1;
			}
		}
		int row_s = left;
		
		//确定右界
		left = 0;
		right = m-1;
		while(left<right && matrix[row_s][right] > target) {
			mid = left + ((right-left)>>1);
			if(matrix[row_s][mid] == target) {
				return true;
			} else if(matrix[row_s][mid]  > target) {
				right = mid - 1;
			} else {
				left = mid+1;
			}
		}
		int col_e = right;
		
		
		//确定左界
		left = 0;
		right = col_e;
		while(left<right && matrix[row_e][left] < target) {
			mid = left + ((right-left)>>1);
			if(matrix[row_e][mid] == target) {
				return true;
			} else if(matrix[row_e][mid] < target) {
				left = mid + 1;
			} else {
				right = mid-1;
			}
		}
		int col_s = left;
		
		return searchMatrix(matrix,row_s,row_e,col_s,col_e,target);  
    }
	
	public boolean searchMatrix(int[][] matrix,int row_s,int row_e,int col_s,int col_e, int target) {
		int left = 0;
		int right = 0;
		int mid = 0;
		for(int i=row_s;i<=row_e;i++) {
			left = col_s;
			right = col_e;
			while(left<=right) {
				mid = left + ((right-left)>>1);
				if(matrix[i][mid] == target) {
					return true;
				} else if(matrix[i][mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		
		return false;	
    }
	
	
	//力扣上的方法四
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		if(target < matrix[0][0] || target > matrix[n-1][m-1]) {
			return false;
		}
		int i = n-1;
		int j = 0;
		while(i>=0 && j<=m-1) {
			if(matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target){
				i--;
			} else {
				j++;
			}
		}
		
		return false;
	}
	
}
