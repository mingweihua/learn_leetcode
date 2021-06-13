package key;

import java.util.LinkedList;

public class LastRemaining {

    //链表解法， 但是会超出时间限制
    public int lastRemaining(int n, int m) {
        if(n==1){
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int removeIndex = 0;
        while (list.size()!=1){
            removeIndex = (removeIndex + m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.get(0);
    }

    //数学解法
    public int lastRemaining2(int n, int m) {
        if(n==1){
            return 0;
        }
        int res = 0;
        for (int i = 2; i<= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
