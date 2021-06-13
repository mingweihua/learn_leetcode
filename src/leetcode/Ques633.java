package leetcode;

public class Ques633 {

	public static void main(String[] args) {
		System.out.println(new Ques633().judgeSquareSum2(2));
	}
	
	
	//超出时间限制
	public boolean judgeSquareSum(int c) {
		
		if(Math.pow((int)Math.sqrt(c), 2) == c) {
			return true;
		};
		
		int cur = 1;
		int temp = 0;
		while(cur*cur < c) {
			temp = c - cur*cur;
			if(Math.pow((int)Math.sqrt(temp), 2) == temp) {
				return true;
			};
			cur++;
		}
		return false;
        
    }
	
	public boolean judgeSquareSum2(int c) {
		int temp = (int)Math.sqrt(c);
		if(Math.pow(temp, 2) == c) {
			return true;
		};
		int a = 1;
		int b = temp;
		int sum = 0;
		while(a<=b) {
			sum = a*a+b*b;
			if(sum == c) {
				return true;
			} else if(sum>c) {
				b--;
			} else {
				a++;
			}
		}
		return false;   
    }
}
