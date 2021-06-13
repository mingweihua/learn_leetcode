package leetcode;

public class Ques190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(43261596));
	}

	public static int reverseBits(int n) {
        if(n==0){
            return 0;
        }
        int res = 0;
        if((n & 1) == 0){
            res = 0;
        } else {
            res = -1;
        }
        int i = 31;
        n = (n>>>1);
        System.out.println(n);
        while(i>0){
            if((n & 1) == 0){
                res = (res<<1);
            } else {
                res = (res<<1) + 1;
            }
            n = (n>>>1);
            i--;
        }
        return res;
    }
}
