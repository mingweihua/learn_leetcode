package shopee;

import java.util.HashMap;

public class Ques202101 {
    public static void main(String[] args) {

    }

    public int romanToInt (String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        HashMap<String,Integer> map_s =new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        map_s.put("IV",4);
        map_s.put("IX",9);
        map_s.put("XL",40);
        map_s.put("XC",90);
        map_s.put("CD",400);
        map_s.put("CM",900);

        int cur = 0;
        int next = 1;
        int res = 0;
        String temp = null;
        while (next<s.length()){
            temp = s.substring(cur,next+1);
            if(map_s.containsKey(temp)){
                res += map_s.get(temp);
                cur += 2;
                next += 2;
            } else {
                res += map.get(s.charAt(cur));
                cur++;
                next++;
            }
        }
        while(cur<s.length()){
            res += map.get(s.charAt(cur));
            cur++;
        }
        return res;
    }
}
