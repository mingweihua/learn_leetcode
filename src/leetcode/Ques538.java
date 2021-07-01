package leetcode;


public class Ques538 {

	public static void main(String[] args) {

	}


	public TreeNode convertBST(TreeNode root) {
		in(root);
		return root;
	}

	int add = 0;
	public void in(TreeNode root){
		if (root == null){
			return;
		}
		in(root.right);

		add += root.val;
		root.val = add;

		in(root.left);
	}
}
