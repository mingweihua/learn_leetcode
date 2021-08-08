package test.meituan;

import java.util.HashMap;
import java.util.Scanner;

/*
7 3 1
2 3
4 5
6 7
0 0
0 0
0 0
0 0
1 2 1
 */
public class Main5 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            map.put(i,new TreeNode(i));
        }
        for (int i = 1; i <= n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            TreeNode cur = map.get(i);
            cur.left = map.getOrDefault(left,null);
            cur.right = map.getOrDefault(right,null);
        }

        for (int i = 1; i <= m ; i++) {
            int temp = sc.nextInt();
            TreeNode cur = map.get(temp);
            TreeNode oldLeft = cur.left;
            cur.left = cur.right;
            cur.right = oldLeft;
        }
        inOrder(map.get(k));
        System.out.println(sb.toString().trim());
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        sb.append(root.val);
        sb.append(" ");
        inOrder(root.right);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

}


