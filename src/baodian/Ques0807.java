package baodian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class Ques0807 {

    ArrayList<String> res = new ArrayList<>();
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> add = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            add.add(i);
            dfs(chars,sb,add);
            sb.deleteCharAt(sb.length()-1);
            add.remove(i);
        }
        return res.toArray(new String[res.size()]);
    }

    public void dfs(char[] chars, StringBuilder sb, HashSet<Integer> add){
        if(sb.length() == chars.length){
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(!add.contains(i)){
                sb.append(chars[i]);
                add.add(i);
                dfs(chars,sb,add);
                sb.deleteCharAt(sb.length()-1);
                add.remove(i);
            }
        }
    }
}
