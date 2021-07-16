package leetcode;


import java.util.LinkedList;

public class Ques426 {


	public static void main(String[] args) {
		Node root = new Node(4);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		root.left = node2;
		root.right = node5;
		node2.left = node1;
		node2.right = node3;
		treeToDoublyList(root);
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	public static Node treeToDoublyList(Node root) {
		if(root == null){
			return null;
		}
		LinkedList<Node> stack = new LinkedList<>();
		Node head = null;
		while (root != null){
			stack.addLast(root);
			root = root.left;
		}
		head = stack.peekLast();

		Node pre = null;
		Node cur = null;
		while (!stack.isEmpty()){
			cur = stack.removeLast();
			cur.left = pre;
			if(pre != null){
				pre.right = cur;
			}
			pre = cur;
			cur = cur.right;
			while (cur != null){
				stack.addLast(cur);
				cur = cur.left;
			}
		}
		head.left = pre;
		pre.right = head;
		return head;
	}
}
