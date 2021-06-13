package leetcode;


public class Ques337 {

	public static void main(String[] args) {
		
	}
	
	public int rob(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = solve(root);
		return Math.max(res[0], res[1]);
    }
	
	
	public int[] solve(TreeNode root) {
		if(root == null) {
			return new int[2];
		}
		int[] left = solve(root.left);
		int[] right = solve(root.right);
		left[0] += (right[0] + root.val);
		left[1] += right[1];
		
		int curMax = Math.max(left[0], left[1]);
		left[0] = left[1];
		left[1] = curMax;
		return left;
    }
}
