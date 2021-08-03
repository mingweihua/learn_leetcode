package baodian;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques0812 {

    public static void main(String[] args) {
        System.out.println(new Ques0812().solveNQueens(4));
    }

    ArrayList<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>(n);
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        int[][] check = new int[n][n];
        for (int j = 0; j < n; j++) {
            check[0][j]++;
            addAfter(check,0,j);
            chars[0][j] = 'Q';

            dfs(chars,check,1,j,n);

            chars[0][j] = '.';
            check[0][j]--;
            deleteAfter(check,0,j);
        }

        return res;
    }

    public void dfs(char[][] chars,int[][] check,int x, int y,int n){
        if(x == n){
            ArrayList<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                one.add(new String(chars[i]));
            }
            res.add(one);
            return;
        }

        for (int j = 0; j < n; j++) {
            if(check[x][j] == 0){

                check[x][j]++;
                addAfter(check,x,j);
                chars[x][j] = 'Q';

                dfs(chars,check,x+1,j,n);


                check[x][j]--;
                deleteAfter(check,x,j);
                chars[x][j] = '.';

            }
        }

    }

    public void addAfter(int[][] check,int x, int y){
        int n = check.length;
        for (int i = x+1; i < n; i++) {
            check[i][y]++;
        }
        for (int i = 1; i < n; i++) {
            if(x+i<n && y+i<n){
                check[x+i][y+i]++;
            }
            if(x+i<n && y-i>=0){
                check[x+i][y-i]++;
            }
        }
    }
    public void deleteAfter(int[][] check,int x, int y){
        int n = check.length;
        for (int i = x+1; i < n; i++) {
            check[i][y]--;
        }
        for (int i = 1; i < n; i++) {
            if(x+i<n && y+i<n){
                check[x+i][y+i]--;
            }
            if(x+i<n && y-i>=0){
                check[x+i][y-i]--;
            }
        }
    }
}
