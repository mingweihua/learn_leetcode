package leetcode;

import java.util.Stack;

public class Ques85 {

	public static void main(String[] args) {
		char[][] arr = {{'1','0','0','0','1'},{'1','1','0','1','1'},{'1','1','1','1','1'}};
		new Ques85().maximalRectangle(arr);
	}
	
	
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] rowArr = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            rowArr[i] = matrix[0][i] - '0';
        }
        int max = 0;
        max = Math.max(max,getRowMax(rowArr));
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == '1'){
                    rowArr[j] = rowArr[j] + 1;
                } else {
                    rowArr[j] = 0;
                }
            }
            max = Math.max(max,getRowMax(rowArr));
        }
        return max;
    }

    public int getRowMax(int[] arr) {
        int rowMax = 0;
        int curIndex = 0;
        int curWidth = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                curIndex = stack.pop();
                if(stack.isEmpty()){
                    curWidth = i;
                } else {
                    curWidth = i - stack.peek() - 1;
                }
                rowMax = Math.max(rowMax,arr[curIndex]*curWidth);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            curIndex = stack.pop();
            if(stack.isEmpty()){
                curWidth = arr.length - 0;
            } else {
                curWidth = arr.length - stack.peek() - 1;
            }
            rowMax = Math.max(rowMax,arr[curIndex]*curWidth);
        }
        return rowMax;
    }

}
