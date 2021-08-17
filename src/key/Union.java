package key;

import java.util.HashMap;
import java.util.List;

public class Union {

    //对应Leetcode题目是399
    //并查集的思想
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
      UnionFind unionFind = new UnionFind(2*size);
        HashMap<String,Integer> map = new HashMap<>(2*size);
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!map.containsKey(a)){
                map.put(a,id++);
            }
            if(!map.containsKey(b)){
                map.put(b,id++);
            }
            unionFind.union(map.get(a),map.get(b),values[i]);

        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(!map.containsKey(a) || !map.containsKey(b)){
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(map.get(a),map.get(b));
            }
        }
        return res;
    }


    private class  UnionFind {

        int[] parents;
        double[] weight;

        public UnionFind(int n){
            parents = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int xroot = find(x);
            int yroot = find(y);
            if (xroot == yroot) {
                return;
            }
            parents[xroot] = yroot;
            weight[xroot] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if(x!=parents[x]){
                int origin = parents[x];
                parents[x] = find(parents[x]);
                weight[x] *= weight[origin];
            }
            return parents[x];
        }

        public double isConnected(int x, int y) {
            int xroot = find(x);
            int yroot = find(y);
            if(xroot == yroot){
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }

    }

}
