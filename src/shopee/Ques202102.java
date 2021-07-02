package shopee;

import java.util.*;

public class Ques202102 {
    public static void main(String[] args) {
        //System.out.println('z' - 'Z');
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //System.out.println(sc);
        //System.out.println((str.charAt(0) - 'a'));
        System.out.println(solve(str));
    }

    public static String solve(String str){
        if(str == ""){
            return "   ";
        }
        //String[] words = null;
        ArrayList<char[]> words= new ArrayList<>();
        if(str.indexOf("-") != -1){
            String[] strs= str.split("-");
            for (int i = 0; i < strs.length; i++) {
                words.add(strs[i].toCharArray());
            }
        } else if(str.indexOf("_") != -1){
            String[] strs= str.split("_");
            for (int i = 0; i < strs.length; i++) {
                words.add(strs[i].toCharArray());
            }
        } else if((str.charAt(0) - 'A') <= 25) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            int cur = 1;
            while(cur<str.length()){
                if(str.charAt(cur) - 'A' <= 25){
                    words.add(sb.toString().toLowerCase().toCharArray());
                    sb = new StringBuilder();
                }
                sb.append(str.charAt(cur));
                cur++;
            }
            words.add(sb.toString().toLowerCase().toCharArray());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            int cur = 1;
            while(cur<str.length()){
                if(str.charAt(cur) - 'A' <= 25){
                    words.add(sb.toString().toLowerCase().toCharArray());
                    sb = new StringBuilder();
                }
                sb.append(str.charAt(cur));
                cur++;
            }
            words.add(sb.toString().toLowerCase().toCharArray());
        }

        StringBuilder res = new StringBuilder();
        for (char[] word : words){
            word[0] = (char) (word[0] - 32);
            res.append(word);
            word[0] = (char) (word[0] + 32);
        }
        res.append(" ");

        for (int i=0;i<words.size();i++){
            if(i==0){
                res.append(words.get(i));
            } else {
                char[] temp = words.get(i);
                temp[0] = (char) (temp[0] - 32);
                res.append(temp);
                temp[0] = (char) (temp[0] + 32);
            }
        }


        res.append(" ");
        for (char[] word : words){
            res.append(word);
            res.append("_");
        }
        res.deleteCharAt(res.length()-1);
        res.append(" ");
        for (char[] word : words){
            res.append(word);
            res.append("-");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }


}
