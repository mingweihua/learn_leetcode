package leetcode;

public class Ques168 {

    public static void main(String[] args) {

    }


    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int mod = 0;
        while (columnNumber > 0) {
            mod = (columnNumber-1) % 26;
            columnNumber = columnNumber / 26;
            sb.append((char)('A' + mod));
        }
        return sb.reverse().toString();
    }
}
