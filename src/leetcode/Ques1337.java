package leetcode;

import java.util.PriorityQueue;

public class Ques1337 {

	public static void main(String[] args) {

	}


	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> {
			if(a[1] != b[1]){
				return b[1] - a[1];
			}
			return b[0] - a[0];
		});

		for (int i = 0; i < mat.length; i++) {
			int[] temp = new int[2];
			temp[0] = i;
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 0){
					break;
				}
				temp[1]++;
			}
			queue.add(temp);
			if(queue.size()>k){
				queue.remove();
			}
		}

		int[] res = new int[k];
		for (int i = k-1; i >= 0 ; i--) {
			if(!queue.isEmpty()){
				res[i] = queue.remove()[0];
			}
		}
		return res;
	}
}
