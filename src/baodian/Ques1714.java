package baodian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ques1714 {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size()>k){
                queue.remove();
            }
        }
        int[] res= new int[k];
        int cur = 0;
        while (!queue.isEmpty()){
            res[cur++] = queue.remove();
        }
        return res;
    }
}
