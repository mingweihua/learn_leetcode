package leetcode;

public class Ques165 {

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0.1";
        System.out.println(new Ques165().compareVersion(version1,version2));
    }


    public int compareVersion(String version1, String version2) {
        String[] nums_str1 = version1.split("\\.");
        String[] nums_str2 = version2.split("\\.");
        int n = Math.min(nums_str1.length,nums_str2.length);
        int i = 0;
        for (; i < n; i++) {
            Integer a1 = Integer.valueOf(nums_str1[i]);
            Integer a2 = Integer.valueOf(nums_str2[i]);
            if(a1<a2){
                return -1;
            } else if(a1 > a2){
                return 1;
            }
        }
        while (i<nums_str1.length){
            Integer a1 = Integer.valueOf(nums_str1[i]);
            if(a1>0){
                return 1;
            }
            i++;
        }
        while (i<nums_str2.length){
            Integer a2 = Integer.valueOf(nums_str2[i]);
            if(a2>0){
                return -1;
            }
            i++;
        }
        return 0;
    }
}
