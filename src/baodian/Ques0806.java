package baodian;

import java.util.ArrayList;
import java.util.List;

public class Ques0806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        if(n==1){
            C.add(A.remove(0));
            return;
        }
        move(n,A,B,C);
    }

    public void move(int n,List<Integer> A, List<Integer> B, List<Integer> C) {
        if(n == 0){
            return;
        }
        move(n-1,A,C,B);
        C.add(A.remove(A.size()-1));
        move(n-1,B,A,C);
    }
}
