package leetcode;

public class Ques148 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		new Ques148().sortList(node1);
	}
	
	public ListNode sortList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode halfPre = getHalf(head);
        ListNode half = halfPre.next;
        halfPre.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(half);
        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right) {
        if(left == null && right == null ){
            return null;
        }
        if(left == null || right == null ){
            return left==null?right:left;
        }
        if(left == right){
            return left;
        }
        ListNode leftHead = left;
        ListNode rightHead = right;
        ListNode newHead;
        if(left.val < right.val){
            newHead = left;
            leftHead = leftHead.next;    
        } else {
            newHead = right;
            rightHead = rightHead.next;  
        }
        ListNode cur = newHead;
        while(leftHead!=null && rightHead!=null){
            if(leftHead.val<rightHead.val){
                cur.next = leftHead;
                leftHead = leftHead.next;
                cur = cur.next;
                cur.next = null;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
                cur = cur.next;
                cur.next = null;
            }
        }

        while(leftHead!=null){
            cur.next = leftHead;
            leftHead = leftHead.next;
            cur = cur.next;
            cur.next = null;
        }

        while(rightHead!=null){
            cur.next = rightHead;
            rightHead = rightHead.next;
            cur = cur.next;
            cur.next = null;
        }
        return newHead;
    }

    public ListNode getHalf(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode fast = head;
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        while(fast!=null &&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
