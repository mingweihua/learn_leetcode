package leetcode;

public class Ques543 {

	public static void main(String[] args) {
		
	}
	int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		
		dfs(root);
		return res;
    }
	
	public int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = dfs(root.left);
		int right = dfs(root.right);
		res = Math.max(res, left+right);
		
		return Math.max(left, right) +1;
    }
}
