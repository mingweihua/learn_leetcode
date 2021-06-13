package leetcode;

public class Ques28 {
	

	public static void main(String[] args) {
		
		new Ques28().strStr("aabaaabaaac", "aabaaac");
	}

	public int strStr(String haystack, String needle) {
        int n = needle.length();
        if(n==0){
            return 0;
        }
        if(haystack.length()<n){
            return -1;
        }
        int[] next = new int[n];
        next[0] = 0;
        int j=0;
        for(int i=1;i<n;i++){
            while(j>0 && needle.charAt(j)!=needle.charAt(i)) {
                j = next[j-1];
            }

            if(needle.charAt(j)==needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }

        int k = 0;
        for(int i=0;i<haystack.length();i++){
            while(k>0 && haystack.charAt(i) != needle.charAt(k)){
                k = next[k-1];
            }
            if(haystack.charAt(i) == needle.charAt(k)){
                k++;
            }
            if(k == n){
                return i-n+1;
            }
        }
        return -1;
    }
}