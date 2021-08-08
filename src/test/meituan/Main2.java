package test.meituan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = str.trim();
        StringBuilder sb = new StringBuilder();
        char pre = str2.charAt(0);
        sb.append(pre);
        for (int i = 1; i < str2.length(); i++) {
            char temp = str2.charAt(i);
            if(temp == ' ' || temp == pre){
                continue;
            }
            sb.append(temp);
            pre = temp;
        }
        System.out.println(sb.toString());
    }

}


