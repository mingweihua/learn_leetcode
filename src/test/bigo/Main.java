package test.bigo;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertString(" hello how are    you   ;"));
    }

    public static String convertString(String original){
        if (original == null || original.equals("")){
            return "";
        }
        String str = original.split(";")[0].trim();
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >=0 ; i--) {
            if(!(strs[i].equals("") || strs[i].equals(" "))){
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(";");
        return sb.toString();
    }

}
