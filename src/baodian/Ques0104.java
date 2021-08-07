package baodian;

import java.util.HashMap;

public class Ques0104 {


    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }
        int temp = 0;
        for (Character key : map.keySet()){
            if (map.get(key) % 2 != 0){
                temp++;
            }
            if(temp>1){
                return false;
            }
        }

        return true;
    }
}
