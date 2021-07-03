package shopee;

import java.util.ArrayList;
import java.util.Scanner;

public class Ques202103 {
    public static void main(String[] args) {
        String str = "3*[a2*[c]]";
        int start = str.indexOf("*[");
        int end = str.lastIndexOf("]");
        System.out.println(str.substring(start+2,end));
    }
    //"3*[a2*[c]]"

    public String computeString (String str) {


        return solve(str);
    }

    public String solve(String str){
        int start = str.indexOf("*[");
        if(start == -1){
            return str;
        }
        int end = str.lastIndexOf("]");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder numberBuilder = new StringBuilder();
        int cur = start-1;
        while(cur >= 0 && str.charAt(cur)-'0' <= 9){
            numberBuilder.append(str.charAt(cur));
            cur--;
        }
        int num = Integer.valueOf(numberBuilder.reverse().toString());
        while (cur>=0) {
            stringBuilder.append(str.charAt(cur));
            cur--;
        }
        stringBuilder.reverse();
        String child = solve(str.substring(start+2,end));
        for (int i = 0; i < num; i++) {
            stringBuilder.append(child);
        }
        for (int i = end+1; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

}
