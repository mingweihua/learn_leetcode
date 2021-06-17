package leetcode;

public class Ques65 {

	public static void main(String[] args) {
		String[] right = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
		String[] wrong = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
		for (int i = 0; i < right.length; i++) {
			System.out.print(new Ques65().isNumber(right[i]) + ",");
		}
		System.out.println();
		for (int i = 0; i < wrong.length; i++) {
			System.out.print(new Ques65().isNumber(wrong[i]) + ",");
		}
	}

	public boolean isNumber(String s) {
		String regex = "[+-]?(\\d+\\.\\d*|\\.\\d+|\\d+)([eE][+-]?\\d+)?";
		return s.matches(regex);
	}

}
