package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Ques218 {

	public static void main(String[] args) {

	}
    //看了答案才会的
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> {return b[1] - a[1];});
        List<Integer> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(building[0]);
            list.add(building[1]);
        }
        Collections.sort(list);
        List<List<Integer>> res = new ArrayList<>();
        int preHeight = 0;
        int index = 0;
        int curHeight = 0;
        for (int boundary : list){
            while (index<buildings.length && buildings[index][0]<=boundary){
                queue.add(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while(!queue.isEmpty() && queue.peek()[0]<=boundary){
                queue.remove();
            }
            curHeight = queue.isEmpty()?0:queue.peek()[1];
            if(!res.isEmpty() && res.get(res.size()-1).get(1) == curHeight){
                continue;
            }
            List<Integer> one = new ArrayList<>(2);
            one.add(boundary);
            one.add(curHeight);
            res.add(one);
        }

        return res;
    }
}