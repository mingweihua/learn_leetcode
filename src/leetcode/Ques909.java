package leetcode;


import java.util.HashSet;
import java.util.LinkedList;

public class Ques909 {

    public static void main(String[] args) {
		int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		System.out.println(new Ques909().snakesAndLadders(board));
    }

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int target = n * n -1;

		HashSet<Integer> visited = new HashSet<>();
		visited.add(0);
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(0);
		int step = 0;
		int size = 0;
		int cur = 0;
		int next = 0;
		int temp = 0;
		while (!queue.isEmpty()) {
			step++;
			size = queue.size();
			for (int i = 0; i < size; i++) {
				cur = queue.remove();
				for (int j = 1; j <= 6 ; j++) {
					next = cur + j;

					if((temp = board[getRow(n,next)][getCol(n,next)]) != -1) {
						next = temp-1;
					}
					if(next == target) {
						return step;
					}
					if(!visited.contains(next)){
						queue.add(next);
						visited.add(next);
					}
				}
			}
		}
		return -1;
	}

	public int getRow(int length, int cur){
		return length-1-cur/length;
	}

	public int getCol(int length, int cur){
		if((cur/length)%2 == 0){
			return cur % length;
		} else {
			return length-1 -(cur%length);
		}
	}
}
