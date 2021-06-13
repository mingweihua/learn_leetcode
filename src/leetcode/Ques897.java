package leetcode;

import java.util.ArrayList;

public class Ques897 {

	public static void main(String[] args) {

	}
	
	
	private TreeNode newRoot = null;
	private TreeNode cur = null;
	public TreeNode increasingBST(TreeNode root) {
		if(root==null) {
			return null;
		}
		inOrder(root);
		return newRoot;	
    }
	//下面这个方法当初想的时候有点绕晕
	public void inOrder(TreeNode root) {
		if(root.left != null) {
			inOrder(root.left);
		}
		
		if(root.left == null && newRoot == null) {
			newRoot = root;
			cur = root;
		} else if (cur != null) {
			root.left = null;
			cur.right = root;
			cur = cur.right;
		}
		
		if(root.right != null) {
			inOrder(root.right);
		}
    }
	
	
	//类似链表的不存数据的头结点机制（哨兵），其实哨兵可以方便解题，避免思路的绕晕；
	private TreeNode head = null;
	public TreeNode increasingBST2(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode res = new TreeNode(-1);
		head = res;
		inOrder2(root);
		return res.right;	
    }

	public void inOrder2(TreeNode root) {
		if(root ==null) {
			return;
		}
		inOrder2(root.left);
		root.left = null;
		head.right = root;
        head = root;
		inOrder2(root.right);
    }
	
	
	//如果单纯的中序迭代遍历，这个就很简单，不会绕晕，因此在使用一个list结构存储所有节点
	private ArrayList<TreeNode> list;
	public TreeNode increasingBST3(TreeNode root) {
		if(root==null) {
			return null;
		}
		list = new ArrayList<TreeNode>();
		inOrder3(root);
		for(int i=0;i<list.size()-1;i++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i+1);
		}
		list.get(list.size()-1).left = null;
		return list.get(0);	
    }

	public void inOrder3(TreeNode root) {
		if(root ==null) {
			return;
		}
		inOrder3(root.left);
		list.add(root);
		inOrder3(root.right);
    }
}
