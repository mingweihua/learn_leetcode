package baodian;

import java.util.HashSet;


public class Ques0808 {

    public static void main(String[] args) {
        System.out.println(new Ques0808().permutation("qqe"));
    }

    HashSet<String> set = new HashSet<>();

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            check[i] = true;
            dfs(chars,sb,check);
            sb.deleteCharAt(sb.length()-1);
            check[i] = false;
        }

        return set.toArray(new String[set.size()]);
    }

    public void dfs(char[] chars, StringBuilder sb,  boolean[] check){
        if(sb.length() == chars.length){
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(!check[i]){
                sb.append(chars[i]);
                check[i] = true;
                dfs(chars,sb,check);
                sb.deleteCharAt(sb.length()-1);
                check[i] = false;
            }
        }
    }
}
