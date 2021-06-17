package vivo;

import java.util.Arrays;
import java.util.LinkedList;

public class Test2020A {


    //问题2
    public int solution2 (int n) {
        if(n<10){
            return n;
        }
        StringBuilder sb = new StringBuilder();
        int i = 9;
        while(n >= 10 && i>=2){
            if(n%i==0){
                sb.append(i);
                n = n/i;
            } else {
                i--;
            }
        }
        if(n>=10){
            return -1;
        }
        sb.append(n);

        return Integer.valueOf(sb.reverse().toString());
    }

    //问题3
    public int solution3(int n) {
        int cur = 1;
        int res = 0;
        while(((cur+1)*cur/2)<=n){
            res += cur*cur;
            cur++;
        }
        int left = n - (((cur-1)+1)*(cur-1)/2);
        res += left*cur;
        return res;
    }
}
