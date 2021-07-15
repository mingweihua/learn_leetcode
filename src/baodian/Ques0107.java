package baodian;

public class Ques0107 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Ques0107().rotate(matrix);
    }

    /*
    给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？
     */

    //leetcode答案的方法二其实就是我想的
    /*leetcode答案的方法三用翻转代替旋转，其实最后得出的表达式是一样的，但是不需要
        像方法二那样一下子处理4个转换

     */
    public  void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            if(i == n-i-1){
                continue;
            }
            for (int j = i; j < n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
