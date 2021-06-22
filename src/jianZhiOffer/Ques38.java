package jianZhiOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ques38 {

    HashSet<String> res = new HashSet<String>();
    public String[] permutation(String s) {
        if(s.length() == 0){
            return new String[0];
        }
        if(s.length() == 1){
            String[] one = new String[1];
            one[0] = s;
            return one;
        }
        for (int i = 0; i < s.length(); i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            dfs(set,s,sb);
        }
        String[] strings = new String[res.size()];
        return res.toArray(strings);
    }

    public void dfs(Set<Integer> selected,String s,StringBuilder pre){
        if(selected.size() == s.length()){
            res.add(pre.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(selected.contains(i)){
                continue;
            }
            selected.add(i);
            pre.append(s.charAt(i));
            dfs(selected,s,pre);
            pre.deleteCharAt(pre.length()-1);
            selected.remove(i);
        }
    }
}
