package baodian;


import leetcode.TreeNode;

public class Ques0402 {


    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }


    public TreeNode create(int[] nums,int start,int end){
        if(end < start){
            return null;
        }
        int mid = start + ((end - start)>>1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(nums,start,mid-1);
        node.right = create(nums,mid+1,end);

        return node;
    }
}
