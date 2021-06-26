package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Ques773 {

	public static void main(String[] args) {

	}

	//看了答案才想到广度优先搜索
	int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
	public int slidingPuzzle(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
		}
		String start = sb.toString();
		int step = 0;
		if (start.equals("123450")){
			return step;
		}
		LinkedList<String> queue = new LinkedList<>();
		queue.add(start);
		HashSet<String> visited = new HashSet<>();
		visited.add(start);
		String temp;
		int size;
		while (!queue.isEmpty()) {
			step++;
			size = queue.size();
			for (int i = 0; i < size; i++) {
				temp = queue.remove();
				for (String ele : getNextStatus(temp)) {
					if(ele.equals("123450")){
						return step;
					}
					if(!visited.contains(ele)){
						visited.add(ele);
						queue.add(ele);
					}
				}
			}
		}
		
		return -1;
	}

	public List<String> getNextStatus(String start) {
		List<String> res = new ArrayList<>();
		int pos = start.indexOf('0');
		char[] array = start.toCharArray();
		for (int b : neighbors[pos]) {
			swag(array,pos,b);
			res.add(new String(array));
			swag(array,b,pos);
		}
		return res;
	}

	public void swag(char[] array, int a, int b){
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
