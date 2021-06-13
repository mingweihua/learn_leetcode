package leetcode;

public class Ques297 {
	

	public static void main(String[] args) {
		String s = "4,-7,n,n,-3,-9,n,n,3,n,n";
		System.out.println(new Ques297().deserialize(s));
	}
	
	StringBuilder preOrder;
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	preOrder = new StringBuilder();
    	dfs(root);
		return preOrder.deleteCharAt(preOrder.length()-1).toString();
    }
    
    private void dfs(TreeNode root) {
    	if(root == null) {
    		preOrder.append("n,");
    		return;
    	}
    	preOrder.append(root.val);
    	preOrder.append(",");
    	dfs(root.left); 	
    	dfs(root.right);
    }
    
    //4,-7,n,n,-3,-9,n,n,3,n,n   ;
    String[] strs;
    int cur = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	strs = data.split(",");
    	cur = 0;
		return makeTree();     
    }
    
   
   
    private TreeNode makeTree() {
    	if(cur >= strs.length){
            return null;
        }
    	if(strs[cur].equals("n")) {
            cur++;
    		return null;
    	}
    	TreeNode newNode = new TreeNode(Integer.valueOf(strs[cur]));
    	cur++;
    	newNode.left = makeTree();
    	newNode.right = makeTree();
		return newNode;	
    }
}