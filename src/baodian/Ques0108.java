package baodian;

import java.util.ArrayList;

public class Ques0108 {

    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            for (int x = 0; x < matrix.length; x++) {
                matrix[x][temp[1]] = 0;
            }
            for (int y = 0; y < matrix[0].length; y++) {
                matrix[temp[0]][y] = 0;
            }
        }
    }
}
