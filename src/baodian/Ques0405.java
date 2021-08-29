package baodian;
import leetcode.TreeNode;

import java.util.LinkedList;

public class Ques0405 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node3;
        System.out.println(new Ques0405().isValidBST(root));
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        return dfs(root);
    }

    public boolean dfs(TreeNode root){
        if (root == null){
            return true;
        }
        boolean flag = dfs(root.left);
        if(!flag){
            return false;
        }
        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        return dfs(root.right);
    }


    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null ){
            while (root != null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(root.val<=pre){
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
