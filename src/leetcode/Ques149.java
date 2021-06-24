package leetcode;

import java.util.HashMap;

public class Ques149 {

	public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(new Ques149().maxPoints(points));
	}
    //这道题的难点在于斜率的表示
    public int maxPoints(int[][] points) {
        int res = 0;
        HashMap<Integer,Integer> map;
        int key = 0;
        int nums = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < points.length-1; i++) {
            map = new HashMap<>(points.length - i);
            for(int j=i+1;j<points.length;j++){
                x = points[j][0] - points[i][0];
                y = points[j][1] - points[i][1];
                if(x == 0){
                    y = 1;
                } else if(y==0){
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }

                key = y + x * 20001;
                nums = map.getOrDefault(key,0)+1;
                map.put(key,nums);
                res = Math.max(res,nums);
            }
        }

        return res+1;
    }

    public int gcd(int a,int b){
	    return b==0?a : gcd(b,a%b);
    }
    
}
