package baodian;

import java.util.*;

public class Ques1626 {


    public int calculate(String s) {
        String s1 = s.trim();
        if(s1.length() == 0){
            return 0;
        }
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> ope = new LinkedList<>();
        if(s1.charAt(0) - '0' <0 || s1.charAt(0) - '0' >9){
            nums.add(0);
        }
        int pre = 0;
        Integer temp;
        Character c;
        int cur = 0;
        boolean needToC = false;
        while(cur <= s1.length()-1){
            c = s1.charAt(cur);
            if( (c - '0' >=0 && c - '0' <=9) || c == ' '){
                cur++;
            } else {
                temp = getNum(s1,pre,cur);
                if(temp != null && needToC){
                    Integer preNum  = nums.removeLast();
                    if(ope.removeLast() == '*'){
                        temp = preNum * temp;
                    } else {
                        temp = preNum / temp;
                    }
                    needToC = false;
                }
                if(temp != null){
                    nums.add(temp);
                }
                if(c=='*' || c=='/'){
                    needToC = true;
                }
                ope.add(c);
                cur++;
                pre = cur;
            }
        }

        temp = getNum(s1,pre,cur);
        if(temp != null && needToC){
            Integer preNum  = nums.removeLast();
            if(ope.removeLast() == '*'){
                temp = preNum * temp;
            } else {
                temp = preNum / temp;
            }
            needToC = false;
        }
        if(temp != null){
            nums.add(temp);
        }

        Integer temp2;
        while (!ope.isEmpty()) {
            temp = nums.removeFirst();
            temp2 = nums.removeFirst();
            if(ope.removeFirst() == '+'){
                temp = temp + temp2;
            } else {
                temp = temp - temp2;
            }
            nums.addFirst(temp);
        }
        return nums.removeFirst();
    }

    public Integer getNum(String s, int start ,int end){
        StringBuilder sb = new StringBuilder();
        char c ;
        for (int i = start; i < end; i++) {
            c = s.charAt(i);
            if (c != ' '){
                sb.append(c);
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
