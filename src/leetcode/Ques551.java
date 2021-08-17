package leetcode;

public class Ques551 {

	public static void main(String[] args) {
		
	}

	public boolean checkRecord(String s) {
		int numA = 0;
		int maxL = 0;
		int numL = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if(cur == 'L'){
				numL++;
				maxL = Math.max(maxL,numL);
				continue;
			}

			if(cur == 'A'){
				numA++;
			}
			numL = 0;
		}
		return numA<2 && maxL<3;
	}
}
