package baodian;

public class Ques17124 {

    public static void main(String[] args) {
        int[][]  matrix = {{9,-8,1,3,-2},{-3,-50,6,-2,4},{6,-4,-4,-5,-7},{5,4,-4,8,-7}};
        System.out.println(new Ques17124().getMaxMatrix(matrix));
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int[][] sum = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int max = Integer.MIN_VALUE;
        int[] res = new int[4];
        int[] pre = new int[matrix[0].length+1];
        for (int up = 0; up < sum.length; up++) {
            for (int down = up+1; down < sum.length; down++) {

                int pre_min_index = 0;
                int pre_min = 0;
                for (int i = 1; i < pre.length ; i++) {
                    pre[i] = sum[down][i] - sum[up][i];
                    if(pre[i] - pre_min > max){
                        max = pre[i] - pre_min;
                        res[0] = up;
                        res[1] = pre_min_index;
                        res[2] = down-1;
                        res[3] = i-1;
                    }

                    if(pre[i] < pre_min){
                        pre_min = pre[i];
                        pre_min_index = i;
                    }
                }

            }
        }
        return res;
    }
}
