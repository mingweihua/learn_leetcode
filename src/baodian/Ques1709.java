package baodian;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Ques1709 {


    //时间和空间也比较大
    public int getKthMagicNumber(int k) {
        if(k==1){
            return 1;
        }
        int num = 1;
        long res = 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        queue.add(3L);
        queue.add(5L);
        queue.add(7L);
        while (num<k){
            long temp = queue.remove();
            if(!set.contains(temp)){
                num++;
                res = temp;
                queue.add(res * 3);
                queue.add(res * 5);
                queue.add(res * 7);
                set.add(temp);
            }
        }
        return (int)res;
    }

    //答案 ， 三指针
    public int getKthMagicNumber2(int k) {
        if(k==1){
            return 1;
        }
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for (int i = 1; i < k; i++) {
            int min = Math.min(res[p3] * 3, Math.min(res[p5]*5,res[p7]*7));
            res[i] = min;
            if(min == res[p3] * 3){
                p3++;
            }
            if(min == res[p5] * 5){
                p5++;
            }
            if(min == res[p7] * 7){
                p7++;
            }
        }
        return res[k-1];
    }
}
