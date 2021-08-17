package baodian;

public class Ques0105 {

    public static void main(String[] args) {
        String first = "intention";
        String second = "execution";
        System.out.println(new Ques0105().oneEditAway(first,second));
    }

    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)){
            return true;
        }
        int n = first.length();
        int m = second.length();
        if(Math.abs(n - m) >= 2){
            return false;
        }
        int change = 1;
        if(n == m){
            int cur = 0;
            while (cur<n && change>=0){
                if(first.charAt(cur) != second.charAt(cur)){
                    change--;
                }
                cur++;
            }
            if(change<0){
                return false;
            }
            return true;
        }
        if(n>m){
            String temp = second;
            second = first;
            first = temp;
            int temp_num = m;
            m = n;
            n = temp_num;
        }

        int cur1 = 0;
        int cur2 = 0;
        while (cur1<n && cur2 < m && change>=0){
            if(first.charAt(cur1) != second.charAt(cur2)){
                change--;
                cur2++;
                continue;
            }
            cur1++;
            cur2++;
        }
        if (change<0){
            return false;
        }
        return true;
    }
}
