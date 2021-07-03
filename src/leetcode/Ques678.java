package leetcode;

public class Ques678 {

	public static void main(String[] args) {
	}
    /*
    l和r表示分别表示「可能多余的左括号」的下界和上界，很直观。执行起来就是:

1. 遇到左括号：l++, r++；
2. 遇到星号：l--, r++（因为星号有三种情况）；
3. 遇到右括号：l--, r--。

在判断的过程中，l要保持不小于0。
另外，如果r < 0，说明把星号全变成左括号也不够了，false。
最后，如果l > 0，说明末尾有多余的左括号，false。

     */
    public boolean checkValidString(String s) {
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
