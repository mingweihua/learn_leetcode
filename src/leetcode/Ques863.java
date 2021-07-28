package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ques863 {

	public static void main(String[] args) {
		
	}

    List<Integer> res = new ArrayList<>();
	HashSet<TreeNode> check = new HashSet<>();
    boolean flag = false;
    int left = 0;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        left = k;
        findChild(target,target,k);
        check.add(target);
        if(root != target){
            findOthers(root,target);
        }
        return res;
    }

    public void findOthers(TreeNode root, TreeNode target) {
        if(root == null){
            return;
        }
        if(root == target){
            flag = true;
            left-- ;
            return;
        }

        findOthers(root.left,target);
        if(flag){
            if(left >= 0){
                findChild(root,target, left);
            }
            left--;
            check.add(root);
            return;
        }
        findOthers(root.right,target);
        if(flag){
            if(left >= 0){
                findChild(root,target, left);
            }
            left--;
            check.add(root);
        }
    }


    public void findChild(TreeNode root,TreeNode target, int k) {
        if(root == null){
            return;
        }
        if(check.contains(root)){
            return;
        }

        if(k == 0){
            if(!check.contains(root)){
                res.add(root.val);
                check.add(root);
            }
            return;
        }

        findChild(root.left,target,k-1);
        findChild(root.right,target,k-1);
    }
}
