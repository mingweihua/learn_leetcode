package leetcode;


public class Ques993 {

	public static void main(String[] args) {
		
	}
	
	int xk = 0;
    int yk = 0;
    TreeNode xP = null;
    TreeNode yP = null; 
    TreeNode pre = null; 
    public boolean isCousins(TreeNode root, int x, int y) {
    	if(root == null) {
    		return false;
    	}
    	if(root.val == x || root.val == y) {
    		return false;
    	}
    	dps(root, 0,x,y);
        return xk == yk && xP != yP;
    }
    
    public void dps(TreeNode root,int k, int x, int y) {
    	if(root == null) {
    		return;
    	}
    	if(root.val == x) {
    		xk = k;
    		xP = pre;
    	}
    	if(root.val == y) {
    		yk = k;
    		yP = pre;
    	}
    	pre = root;
    	dps(root.left,k+1,x,y);
    	pre = root;
    	dps(root.right,k+1,x,y);
    }
}
