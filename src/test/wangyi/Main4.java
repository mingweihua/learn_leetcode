package test.wangyi;

import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {

    }

    long[][] prices;
    public int minSailCost (int[][] input) {
        // write code here
        if(input.length == 0 || input[0].length==0){
            return 0;
        }
        if(input.length == 1 && input[0].length==1){
            return 0;
        }
        prices = new long[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            Arrays.fill(prices[i],Long.MAX_VALUE);
        }
        prices[0][0] = 0;
        dfs (input,0,1,0);
        dfs (input,1,0,0);
        return (int)prices[input.length-1][input[0].length-1];
    }

    public void dfs (int[][] input,int x,int y,long curPrice) {
        if(x<0 || x >= input.length || y<0 || y>= input[0].length){
            return;
        }
        if(input[x][y] == 2){
            return;
        }
        long price = curPrice + (input[x][y]==0?2:1);
        if(price >= prices[x][y]){
            return;
        }
        prices[x][y] = price;
        if(x == input.length-1 && y == input[0].length-1){
            return;
        }
        dfs (input,x+1,y,price);
        dfs (input,x-1,y,price);
        dfs (input,x,y+1,price);
        dfs (input,x,y-1,price);
    }


}
