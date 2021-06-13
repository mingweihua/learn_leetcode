package leetcode;

public class PrintArray {
	
	private PrintArray() {
		
	}
	
	public static void print2DArray(int[][] matrix) {
		for(int[] arr: matrix) {
			for(int i : arr) {
				System.out.print(i);
				System.out.print(" , ");
			}
			System.out.println("");
		}
	}
}
