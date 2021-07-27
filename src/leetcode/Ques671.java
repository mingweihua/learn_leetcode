package leetcode;

public class Ques671 {

	public static void main(String[] args) {

	}


    long res = Long.MAX_VALUE;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        if(root.left != null){
            dfs(root);
        }
        return res == Long.MAX_VALUE? -1 : (int)res;
    }

    public void dfs(TreeNode root) {
        if (root.left == null || root.right == null){
            return;
        }

        if(root.left.val == min){
            dfs(root.left);
        } else {
            res = Math.min(res,root.left.val);
        }

        if(root.right.val == min){
            dfs(root.right);
        } else {
            res = Math.min(res,root.right.val);
        }
    }
	
}
