package leetcode;

public class Ques91 {

	public static void main(String[] args) {
		System.out.println(numDecodings("2101"));
	}

	public static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        boolean flag = suit(s.charAt(0), s.charAt(1));
        if(s.charAt(1) == '0' && !flag){
            return 0;
        }
        dp[1] = s.charAt(1) == '0'? 1 : ( 1 + (flag? 1:0));
        for(int i=2;i<dp.length;i++){
            flag = suit(s.charAt(i-1), s.charAt(i));
            if(s.charAt(i) == '0' && !flag){
                return 0;
            }
            dp[i] = s.charAt(1) == '0'? dp[i-2] :  (dp[i-1]+ (flag ? dp[i-2]:0));
        }
        return dp[dp.length-1];
    }

    public static boolean suit(char a,char b){
        if(a == '0'){
            return false;
        }
        int num = Integer.valueOf(""+a+b);
        if(num>=1 && num <=26) {
        	return true;
        }
        return false;
    }
    
    //空间和时间上的优化
    
    public static int numDecodings2(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int a = 1;
        boolean flag = suit(s.charAt(0), s.charAt(1));
        if(s.charAt(1) == '0' && !flag){
            return 0;
        }
        int b = s.charAt(1) == '0'? 1 : ( 1 + (flag? 1:0));
        int c = b;
        for(int i=2;i<s.length();i++){
            flag = suit(s.charAt(i-1), s.charAt(i));
            if(s.charAt(i) == '0' && !flag){
                return 0;
            }
            c = s.charAt(i) == '0'? a :  (b+ (flag ? a:0));
            a = b;
            b = c;        
        }
        return c;
    }

    public static boolean suit2(char a,char b){
        if(a == '0'){
            return false;
        }
        int num = (a-'0')*10 + (b-'0');
        if(num>=1 && num <=26) {
        	return true;
        }
        return false;
    }
}
