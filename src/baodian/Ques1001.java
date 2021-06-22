package baodian;

public class Ques1001 {


    public void merge(int[] A, int m, int[] B, int n) {
        int cur = m+n-1;
        int ap = m-1;
        int bp = n-1;
        while(ap>=0 && bp>=0){
            if(A[ap] >= B[bp]){
                A[cur--] = A[ap--];
            } else {
                A[cur--] = B[bp--];
            }
        }

        while(bp >= 0) {
            A[cur--] = B[bp--];
        }

    }
}
