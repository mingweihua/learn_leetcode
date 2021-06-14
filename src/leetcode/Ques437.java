package leetcode;

import java.util.HashSet;

public class Ques437 {

	public static void main(String[] args) {

	}

	HashSet<Integer> set;
	int res = 0;
	public int pathSum(TreeNode root, int targetSum) {
		set = new HashSet<Integer>();
		dfs(root,targetSum);
		return res;
	}

	public void dfs(TreeNode root, int targetSum) {
		if(root == null){
			return;
		}
		if(set.isEmpty()){
			set.add(root.val);
		} else {
			HashSet<Integer> cur = new HashSet<>();
			for (Integer item : set){
				cur.add(item+ root.val);
			}
			cur.add(root.val);
			set = cur;
		}
		if(set.contains(targetSum)){
			res++;
		}
		dfs(root.left,targetSum);
		dfs(root.right,targetSum);

		HashSet<Integer> re = new HashSet<>();
		for (Integer item : set){
			re.add(item - root.val);
		}
		re.remove(0);
		set = re;
	}
}
