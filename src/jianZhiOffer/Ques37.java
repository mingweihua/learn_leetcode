package jianZhiOffer;

import leetcode.TreeNode;

public class Ques37 {

    public static void main(String[] args) {
        System.out.println(new Ques37().deserialize("1,2,n,n,3,4,n,n,5,n,n"));
    }


    //题目是序列化和反序列化一个树

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        if(root == null){
            sb.append("n");
            return sb.toString();
        }
        dfs(root);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    String[] strs;
    int cur;
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data.equals("n")){
            return null;
        }
        strs = data.split(",");
        cur = 0;
        return create();
    }

    public void dfs(TreeNode root){
        if(root == null){
            sb.append("n,");
            return;
        }
        sb.append(root.val+",");
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode create(){
        if(cur >= strs.length){
            return null;
        }
        if(strs[cur].equals("n")){
            cur++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[cur]));
        cur++;

        node.left = create();
        node.right = create();
        return node;
    }
}
