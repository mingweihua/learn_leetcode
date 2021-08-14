package key;

public class SearchMatrix {

    /*
        对应leetcode上的宝典系列 10.09题
     */
    /*
          排序矩阵查找
          给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
          如果只是二分查找，需要的时间复杂度是logn * logm, 而且判断条件超多；很容易出错或者死循环
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        if(m == 0){
            return false;
        }
        if(target<matrix[0][0] || target>matrix[n-1][m-1]){
            return false;
        }
        if(target == matrix[0][0] || target == matrix[n-1][m-1]){
            return true;
        }
        int row_top = binarySearchRow(n,matrix,0,target);
        int row_bottom = binarySearchRow(n,matrix,m-1,target);
        if(row_bottom > row_top){
            return false;
        }
        int col_left = binarySearchCol(m,matrix,row_top,target);
        int col_right = binarySearchCol(m,matrix,row_bottom,target);
        if(col_left > col_right){
            return false;
        }
        for (int i = row_bottom; i <= row_top ; i++) {
            for (int j = col_left; j <= col_right ; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    public int binarySearchRow(int n,int[][] matrix,int col,int target){
        int left = 0;
        int right = n-1;
        if(matrix[left][col] == target){
            return left;
        }
        if(matrix[right][col] == target){
            return right;
        }
        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(target <= matrix[mid][col]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    public int binarySearchCol(int m,int[][] matrix,int row,int target){
        int left = 0;
        int right = m-1;
        if(matrix[row][left] == target){
            return left;
        }
        if(matrix[row][right] == target){
            return right;
        }
        int mid = 0;
        while (left<right){
            mid = left + ((right-left)>>1);
            if(target <= matrix[row][mid]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    /*
         官方答案，
         试想，假如任取矩阵中的一个值与目标值对比，如果该值大于目标值，则该值的右下方所有的值都大于目标值；
            如果该值小于目标值，则该值的左上方所有的值都小于目标值。
            这里，我们采用分治的思想，具体步骤如下：
            1.初始化位置，从右上角开始
            2.如果当前位置的值等于target，则返回true
            3.如果当前位置的值小于target，则行指针下移
            4.如果当前位置的值大于target，则列指针左移

            为什么从右上角开始呢？因为从右上角开始，每次只有左下方可能有目标值，减少了问题的复杂程度。
            当然，也可以从左下角开始，这样每次只需要考虑右上方。
            最多只需要对比行数m+列数n-1次，所以时间复杂度为O(m+n);
            只用了常数级别的空间，所以空间复杂度为O(1)。
    */

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        if(m == 0){
            return false;
        }
        int x = 0;
        int y = m-1;
        while (x<n && y>=0){
            if(matrix[x][y] == target){
                return true;
            } else if(matrix[x][y] < target){
                x++;
            } else {
                y--;
            }
        }
        return false;
    }


}
