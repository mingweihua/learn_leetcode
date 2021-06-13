package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ques114 {

	public static void main(String[] args) {
		
	}

	public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(root,list);

        if(list.size() ==0 || list.size()==1){
            return;
        }
        root.left = null;
        for(int i=1;i<list.size();i++){
            TreeNode temp = list.get(i); 
            temp.left = null;     
            root.right = temp;
            root = temp;
        }
        root.right = null;
    }

    public void preOrder(TreeNode root,List<TreeNode> list) {
        if(root == null){
            return;
        }
        list.add(root);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

}
