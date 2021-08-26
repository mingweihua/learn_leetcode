package test.TME;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String s = "321";
        int k = 2;
        System.out.println(new Main().maxValue(s,k));
    }


    HashSet<TreeNode> leefSet = new HashSet<>();
    HashSet<TreeNode> leefParSet = new HashSet<>();
    public TreeNode pruneLeaves2(TreeNode root) {
        if(root == null){
            return null;
        }
        order(root);
        if(leefParSet.contains(root)){
            return null;
        }

        return root;
    }

    public void order(TreeNode root){
        if(root.left == null && root.right == null){
            leefSet.add(root);
            return;
        }

        if(root.left!= null){
            order(root.left);
            if(leefSet.contains(root.left)){
                leefParSet.add(root);
                return;
            }
            if(leefParSet.contains(root.left)){
                root.left = null;
            }
        }

        if(root.right != null){
            order(root.right);
            if(leefSet.contains(root.right)){
                leefParSet.add(root);
                return;
            }
            if(leefParSet.contains(root.right)){
                root.right = null;
            }
        }
    }





    public int maxValue (String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 1;
        int left = 0;
        int right = 0;
        StringBuilder numstr = new StringBuilder();
        while (right<n && right-left+1<=k){
            numstr.append(chars[right]);
            right++;
        }
        res = Integer.valueOf(numstr.toString());
        while (right<n){
            numstr.deleteCharAt(0);
            numstr.append(chars[right]);
            res = Math.max(res,Integer.valueOf(numstr.toString()));
            right++;
        }
        return res;
    }


    public int FillArray (int[] a, int k) {
        int mod = 1000000007;
        long res = 1;
        int leftMax = 0;
        int rightMin = k;
        long[][] dp = new long[k+1][a.length+1];
        Arrays.fill(dp[1],1);
        for (int i = 1; i <= k ; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i <= k ; i++) {
            for (int j = 2; j <= a.length; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
            }
        }
        int left = 0;
        while (left<a.length){
            if(a[left]!=0){
                if(a[left]<leftMax){
                    return 0;
                }
                leftMax = a[left];
                left++;
            } else {
                int right = left;
                rightMin = k;
                while (right<a.length && a[right] == 0){
                    right++;
                }
                if(right != a.length){
                    rightMin = a[right];
                }
                if(rightMin<leftMax){
                    return 0;
                }
                int nums = rightMin -leftMax+1;
                int len = right-left;
                res = (dp[nums][len] * res) % mod;
                left = right;
            }
        }
        return (int)res;
    }
}
