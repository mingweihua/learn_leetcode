package key;


public class GCB {

    /*
        求最大公约数，涉及数学方法（阿里的一些笔试题老用这种数学方法）

        理解了，会了就简单，不然时间复杂度肯定超
     */

    public static void main(String[] args) {
        System.out.println(gcd(48,42));
    }

    public static int gcd(int a, int b){
        if(b>a){
            int temp = a;
            a = b;
            b = temp;
        }
        int left = a % b;
        while (left != 0){
            a = b;
            b = left;
            left = a % b;
        }
        return b;
    }

}
