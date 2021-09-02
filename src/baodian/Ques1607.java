package baodian;

public class Ques1607 {

    public static void main(String[] args) {

    }

    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        long k = 1+((c-d)>>63);
        return (int) (a*k+(1^k) *d);
    }

}
