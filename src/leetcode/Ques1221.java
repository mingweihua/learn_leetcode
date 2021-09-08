package leetcode;

public class Ques1221 {

	public static void main(String[] args) {

	}


	public int balancedStringSplit(String s) {
		int numL = 0;
		int res = 0;
		if (s.charAt(0) == 'L'){
			numL++;
		}else {
			numL--;
		}
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == 'L'){
				numL++;
			}else {
				numL--;
			}
			if(numL == 0){
				res++;
			}
		}
		return res;
	}

}
