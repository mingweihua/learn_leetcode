package baodian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques1619 {

    public static void main(String[] args) {
        int[][] land = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        System.out.println(new Ques1619().pondSizes(land));
    }

    List<Integer> res;
    boolean[][] check;
    int curSize = 0;
    public int[] pondSizes(int[][] land) {
        if(land.length == 0){
            return new int[0];
        }
        res = new ArrayList<>();
        check = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if(!check[i][j] && land[i][j] == 0){
                    curSize = 0;
                    dfs(land,check,i,j);
                    res.add(curSize);
                }
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    public void dfs(int[][] land, boolean[][] check,int x,int y){
        if(x<0 || x>=land.length || y<0 || y>=land[0].length){
            return;
        }
        if(check[x][y]){
            return;
        }
        check[x][y] = true;
        if(land[x][y]!=0){
            return;
        }
        curSize++;
        dfs(land,check,x+1,y);
        dfs(land,check,x-1,y);
        dfs(land,check,x,y+1);
        dfs(land,check,x,y-1);
        dfs(land,check,x+1,y+1);
        dfs(land,check,x+1,y-1);
        dfs(land,check,x-1,y-1);
        dfs(land,check,x-1,y+1);
    }

}
