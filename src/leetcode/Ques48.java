package leetcode;

public class Ques48 {
	
	
	public static void main(String[] args) {
		int[][] array = {{15,13, 2, 5},
				  {14, 3, 4, 1},
				  {12, 6, 8, 9},
				  {16, 7,10,11}};
		new Ques48().rotate(array);
		PrintArray.print2DArray(array);
	}
	
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1){
            return;
        }

        int size = matrix.length-1;
        int start = 0;
        while(size > 0){
            for(int j=start;j<start+size;j++){
                swap(matrix,size,start,j);
            }
            start++;
            size = size-2;
        }
    }


    public void swap(int[][] matrix, int length, int i, int j){
        if(length == 0){
            return;
        }
        int step = j - i;
        int up_boundry = i;
        int down_boundry = i + length;
        int left_boundry = i;
        int right_boundry = i + length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[down_boundry-step][left_boundry];
        matrix[down_boundry-step][left_boundry] = matrix[down_boundry][right_boundry-step];
        matrix[down_boundry][right_boundry-step] = matrix[up_boundry + step][right_boundry];
        matrix[up_boundry + step][right_boundry] = temp;
    }
}
