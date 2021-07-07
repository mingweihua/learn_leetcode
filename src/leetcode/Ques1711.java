package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ques1711 {

    public static void main(String[] args) {
        int[] deliciousness = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        //int[] deliciousness = {1,1,1,3,3,3,7};
        System.out.println(new Ques1711().countPairs2(deliciousness));
    }

    //超出时间限制，O(n*n)
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        int res = 0;
        if (deliciousness == null || deliciousness.length==1){
            return res;
        }
        for (int i = 0; i < deliciousness.length-1; i++) {
            for (int j = i+1; j < deliciousness.length; j++) {
                if(check(deliciousness,i,j)){
                    res = (res +1 ) % mod;
                }
            }
        }
        return res;
    }

    public boolean check(int[] deliciousness,int i,int j){
        int sum = deliciousness[i] + deliciousness[j];
        if(sum<1){
            return false;
        }
        if ((sum & (sum-1)) == 0){
            return true;
        }
        return false;
    }


    //也是超出时间限制
    public int countPairs2(int[] deliciousness) {
        int mod = 1000000007;
        int res = 0;
        if (deliciousness == null || deliciousness.length==1){
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);
        }
        int temp = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(check(list.get(i),list.get(j))){
                    if(i==j){
                        temp = map.get(list.get(i));
                        temp = (temp-1) * temp / 2;
                    } else {
                        temp = map.get(list.get(i)) * map.get(list.get(j));
                    }

                    res = (res + temp ) % mod;
                }
            }
        }
        return res;
    }

    public boolean check(int num1,int num2){
        int sum = num1+ num2;
        if(sum<1){
            return false;
        }
        if ((sum & (sum-1)) == 0){
            return true;
        }
        return false;
    }


    /*
        leetcode答案
     */
    public int countPairs3(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

}
