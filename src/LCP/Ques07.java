package LCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Ques07 {
    public static void main(String[] args) {

    }


    //该方法是基于广度优先遍历，时间复杂度为O(n)
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ele : relation) {
            List<Integer> list = map.getOrDefault(ele[0],new ArrayList<>());
            list.add(ele[1]);
            map.put(ele[0],list);
        }

        if(!map.containsKey(0) || k ==0){
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;
        int size = 0;
        int temp = 0;
        while (!queue.isEmpty() && step<k){
            step++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.removeFirst();
                if(map.containsKey(temp)){
                    List<Integer> list = map.get(temp);
                    for (int ele : list) {
                        queue.add(ele);
                    }
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()){
            if(queue.removeFirst() == n-1){
                res++;
            }
        }
        return res;
    }

    //优化时间复杂度，使用动态规划方法
    /*
    官方解答
    前两种方法都是通过在图中搜索计算方案数。可以换一个思路，这道题是计数问题，可以使用动态规划的方法解决。
     */

    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] edge : relation){
                int src = edge[0], dst = edge[1];
                dp[i][dst] += dp[i-1][src];
            }
        }
        return dp[k][n-1];
    }
    /*
        还可以再优化空间复杂度，由于只与上一层有关系，这里不再展示
     */

}
