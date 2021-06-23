package jianZhiOffer;

public class Ques15 {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    //答案的位运算优化
    /*
        多少个1只要计算多少次，比从左到右逐个判断是否是1时间上更短
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
