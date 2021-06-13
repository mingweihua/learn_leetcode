package leetcode;

public class Ques105 {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int root_index = 0;
		for(int i = 0;i<inorder.length;i++) {
			if(inorder[i] == preorder[0]) {
				root_index = i;
				break;
			}
		}
		TreeNode root = new TreeNode(preorder[0]);
		//int leftNums = root_index;
		//int rightNums = inorder.length-1 - root_index;
		root.left = buildTree(preorder,1,root_index,inorder,0,root_index-1);
		root.right = buildTree(preorder,root_index+1,inorder.length-1,inorder,root_index+1,inorder.length-1);
		return root;       
    }
	
	
	public TreeNode buildTree(int[] preorder,int preStart,int preEnd, 
			int[] inorder,int inStart,int inEnd) {
		if(inStart > inEnd) {
			return null;
		}
		if(inStart == inEnd) {
			return new TreeNode(inorder[inStart]);
		}
		int index = 0;
		for(int i = inStart;i<=inEnd;i++) {
			if(inorder[i] == preorder[preStart]) {
				index = i;
				break;
			}
		}
		int leftNums = index-inStart;
		//int rightNums = preEnd - index;
		TreeNode root = new TreeNode(preorder[preStart]);
		root.left = buildTree(preorder,preStart+1,preStart+leftNums,inorder,inStart,index-1);
		root.right = buildTree(preorder,preStart+leftNums+1,preEnd,inorder,index+1,inEnd);
		return root;       
    }
}
