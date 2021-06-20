package baodian;

public class Ques0106 {



    public String compressString(String S) {
        if(S == null || S.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        int num = 1;
        for(int i=1;i<S.length();i++){
            if(S.charAt(i) == S.charAt(i-1)){
                num++;
            } else {
                sb.append(num);
                sb.append(S.charAt(i));
                num = 1;
            }
        }
        sb.append(num);
        return sb.length()>=S.length()?S:sb.toString();
    }
}
