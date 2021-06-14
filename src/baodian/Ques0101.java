package baodian;

public class Ques0101 {
    public boolean isUnique(String str) {
        int temp = 0;
        int cur = 0;
        for(int i=0;i<str.length();i++){
            cur = (1 << (str.charAt(i) - 'a'));
            if((temp & cur) != 0){
                return false;
            }
            temp += cur;
        }
        return true;
    }
}
