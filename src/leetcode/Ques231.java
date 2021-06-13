package leetcode;


public class Ques231 {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
	}
	
	
	public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        int temp = n & (n-1);
        if(temp == 0){
            return true;
        } else {
            return false;
        }
    }
}
