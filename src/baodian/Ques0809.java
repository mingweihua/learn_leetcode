package baodian;

import java.util.ArrayList;
import java.util.List;

public class Ques0809 {

    //HashSet<String> set;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res= new ArrayList<>();
        if(n==0){
            return res;
        }
        //set = new HashSet<>();
        dfs(new StringBuilder(),n,n);
        //res = new ArrayList<>(set);
        return res;
    }

    public void dfs(StringBuilder pre, int lLeft, int rLeft){
        if(lLeft == 0 && rLeft == 0){
            res.add(pre.toString());
            return;
        }

        if(lLeft>=1){
            dfs(pre.append("("),lLeft-1,rLeft);
            pre.deleteCharAt(pre.length()-1);
        }
        if(rLeft>=1 && lLeft<rLeft){
            dfs(pre.append(")"),lLeft,rLeft-1);
            pre.deleteCharAt(pre.length()-1);
        }
    }
}
