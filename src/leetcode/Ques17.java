package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques17 {

	public static void main(String[] args) {
		
	}

	
	List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
		return res;
    }
    
    public void combination(String digits, int cur, String prex) {
        if(cur == digits.length()){
            res.add(prex);
        } else {
            char[] chars = numToChars(digits.charAt(cur));
            for(int i=0;i<chars.length;i++){
                combination(digits,cur+1,prex+chars[i]);
            }
        }
    }
    
    public char[] numToChars(char num){
        switch(num){
        	case '2':
        		char[] chars_2 = {'a','b','c'};
        		return  chars_2;
        	case '3':
        		char[] chars_3 = {'d','e','f'};
        		return  chars_3;
        	case '4':
        		char[] chars_4 = {'g','h','i'};
        		return  chars_4;
        	case '5':
        		char[] chars_5 = {'j','k','l'};
        		return  chars_5;
        	case '6':
        		char[] chars_6 = {'m','n','o'};
        		return  chars_6;
        	case '7':
        		char[] chars_7 = {'p','q','r','s'};
        		return  chars_7;
        	case '8':
        		char[] chars_8 = {'t','u','v'};
        		return  chars_8;
        	case '9':
        		char[] chars_9 = {'w','x','y','z'};
        		return  chars_9;
        	default:
        		char[] chars_0 = {};
        		return  chars_0;	
        }
    }
}
