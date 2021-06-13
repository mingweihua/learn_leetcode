package leetcode;

import java.util.LinkedList;

public class Ques872 {

	public static void main(String[] args) {
		
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
        getLeaf(root1,list1);
        getLeaf(root2,list2);
        if(list1.size() != list2.size()) {
        	return false;
        }
        for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i)!=list2.get(i)) {
				return false;
			}
		}
        return true;
    }
	
	public void getLeaf(TreeNode root, LinkedList<Integer> list) {
        if(root == null) {
        	return;
        }
        if(root.left == null && root.right == null) {
        	list.add(root.val);
        	return;
        }
        
        if(root.left != null) {
        	getLeaf(root.left, list);
        }
        
        if(root.right != null) {
        	getLeaf(root.right, list);
        }
    }
}
