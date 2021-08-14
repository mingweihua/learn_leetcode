package leetcode;

import java.util.HashSet;

public class Ques1583 {

	public static void main(String[] args) {
		int n = 6;
		int[][] preferences = {{3,2,4,5,1},{3,4,2,0,5},{5,0,3,1,4},{2,0,4,5,1},{2,3,5,0,1},{1,4,3,0,2}};
		int[][] pairs = {{5,3},{4,2},{0,1}};
		System.out.println(new Ques1583().unhappyFriends(n,preferences,pairs));
	}

	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		int[] cp = new int[n];
		HashSet<Integer> set = new HashSet<>(n);
		for (int[] pair: pairs) {
			int x = pair[0];
			int y = pair[1];
			cp[x] = y;
			cp[y] = x;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < preferences[i].length; j++) {
				if(preferences[i][j] == cp[i]){
					break;
				}
				int temp = preferences[i][j];
				int temp_cp = cp[temp];
				for (int k = 0; k < preferences[temp].length; k++) {
					if(preferences[temp][k] == temp_cp){
						break;
					}
					if(preferences[temp][k] == i){
						set.add(temp);
						set.add(i);
						break;
					}
				}
			}

		}
		return set.size();
	}

	public boolean unhappyFriends(int n, int[][] preferences, int x, int y) {

		for (int i = 0; i < preferences[x].length; i++) {
			if(preferences[x][i] == y){
				break;
			}
			int temp = preferences[x][i];

		}
		return false;
	}


}
