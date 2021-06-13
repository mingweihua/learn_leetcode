package leetcode;

public class Ques12 {

	public static void main(String[] args) {

	}

	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        int i = 0;
        while(i<values.length) {
			if(values[i]>num) {
				i++;
				continue;
			}
			while (i<values.length && num >= values[i]) {
				num -= values[i];
				roman.append(symbols[i]);
			}
		}
        return roman.toString();
    }

}
