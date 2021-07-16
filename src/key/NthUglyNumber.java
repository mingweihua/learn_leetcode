package key;

public class NthUglyNumber {


    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int min = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            res[i] = min;
            if(min == res[p2]*2) {
                p2++;
            }
            if(min == res[p3]*3) {
                p3++;
            }
            if(min == res[p5]*5) {
                p5++;
            }
        }
        return res[n-1];
    }
}
