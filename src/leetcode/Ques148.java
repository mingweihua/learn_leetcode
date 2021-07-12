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


    //时间复杂度为O(nlogn),空间为常熟，就是归并排序，但是必须是自底而上的，否则是O(logn)空间复杂度
    public ListNode sortList2(ListNode head) {
	    ListNode newHead = new ListNode(-1);
	    newHead.next = head;
	    int length = 0;
        ListNode cur = head;
	    while (cur!=null){
            length++;
            cur = cur.next;
        }
        for (int i = 1; i <= length; i<<=1) {
            ListNode pre = newHead;
            while (pre.next != null){
                ListNode head1 = pre.next;
                ListNode head1End = head1;
                int n = i;
                while (n>1 && head1End != null){
                    head1End = head1End.next;
                    n--;
                }
                //head1End为空，即只有一条链，不需要合并
                if(head1End == null || head1End.next == null) {
                    break;
                }
                //断开3个子链
                pre.next = null;
                ListNode head2 = head1End.next;
                head1End.next = null;
                ListNode head2End = head2;
                n = i;
                while (n>1 && head2End != null){
                    head2End = head2End.next;
                    n--;
                }
                //head2End不为空，即后面还有元素了，为下一次的合并操作的head1
                ListNode next = null;
                if(head2End != null){
                    next = head2End.next;
                    head2End.next = null;
                }
                ListNode newEnd = merge(pre,head1,head2);
                newEnd.next = next;
                pre = newEnd;
            }
        }


        return newHead.next;
    }

    public ListNode merge(ListNode pre, ListNode head1, ListNode head2) {
	    while(head1 != null && head2 != null){
	        if(head1.val <= head2.val){
	            pre.next = head1;
	            head1 = head1.next;
	            pre = pre.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
                pre = pre.next;
            }
        }

        while(head1 != null){
            pre.next = head1;
            head1 = head1.next;
            pre = pre.next;
        }

        while(head2 != null){
            pre.next = head2;
            head2 = head2.next;
            pre = pre.next;
        }
        pre.next = null;
        return pre;
    }
}
