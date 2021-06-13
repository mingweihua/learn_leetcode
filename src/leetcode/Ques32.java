package leetcode;

public class Ques32 {

	public static void main(String[] args) {
		System.out.println(new Ques32().longestValidParentheses(")())()(())"));
	}
	
	
	public int longestValidParentheses(String s) {
		if(s==null || s.length()<=1){
            return 0;
        }

        int[] temp = new int[s.length()];
        temp[0] = 0;
        if(s.charAt(1) == ')' && s.charAt(0) == '('){
           temp[1] = 2;
        }
        for(int i=2;i<temp.length;i++){

            if(s.charAt(i) == '('){
                temp[i] = 0;
                continue;
            } else {
                if(s.charAt(i-1) == '('){
                    temp[i] = temp[i-2] + 2;
                } else {
                    if(i-1-temp[i-1]>=0 && s.charAt(i-1-temp[i-1]) == '('){
                        temp[i] = temp[i-1] + 2;
                        if(i-1-temp[i-1]-1 >= 0) {
                        	 temp[i] += temp[i-1-temp[i-1]-1];
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<temp.length;i++){
            max = temp[i]> max? temp[i] : max; 
        }
        return max;
    }
}
