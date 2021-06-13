package leetcode;

public class Ques236 {

	public static void main(String[] args) {

	}
	
	public boolean findOne = false;
	public TreeNode nextToFind = null;
	public TreeNode res = null;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == p || root == q) {
			return root;
		}
		findOne(root,p,q);
		return res;       
    }
	
	
	public void findOne(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || res != null) {
			return;
		}
		if(root == p || root == q) {
			findOne = true;
			nextToFind = root== q?p:q;
			boolean flag = findOther(root,nextToFind);
			if(flag) {
				res = root;
			}
			return;
		} 
		findOne(root.left,p,q);
		if(findOne && res!=null) {
			return;		
		}
		if(findOne && res==null) {
			boolean flag = findOther(root.right, nextToFind);
			if(flag) {
				res = root;
			}
			return;		
		}
		
		findOne(root.right,p,q);
	}
	
	public boolean findOther(TreeNode root, TreeNode other) {
		if(root == null) {
			return false;
		}
		if(root == other) {
			return true;
		}
		return findOther(root.left,other) || findOther(root.right,other);		
	}
	
	/*public boolean findp(TreeNode root, TreeNode p) {
		if(root == null) {
			return false;
		}
		if(root == p) {
			return true;
		}
		return findp(root.left,p) || findp(root.right,p);		
	}
	
	public boolean findq(TreeNode root, TreeNode q) {
		if(root == null) {
			return false;
		}
		if(root == q) {
			return true;
		}
		return findq(root.left,q) || findq(root.right,q);		
	}*/
}
