package shopee;

public class Ques202105 {
    public static void main(String[] args) {

    }

    public boolean checkValidString (String s) {
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lo++;
                hi++;
            } else if(s.charAt(i) == ')'){
                if(lo==0){
                    hi--;
                } else {
                    lo--;
                    hi--;
                }
            } else {
                hi++;
                if(lo>0){
                    lo--;
                }
            }
            if(hi<0){
                return false;
            }
        }
        return lo<=0;
    }

}
