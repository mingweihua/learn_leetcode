package leetcode;

public class Ques160 {

	public static void main(String[] args) {
		ListNode c1 = new ListNode(8);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(1);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(1);
		
		c1.next = c2;
		c2.next = c3;
		
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;
		
		a1.next = a2;
		a2.next = c1;
		
		System.out.println(new Ques160().getIntersectionNode(a1, b1));
	}
	

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        if(headA == headB){
            return headA;
        }
        ListNode tailA = headA;
        ListNode tailB = headB;
        int len = 1;
        while(tailA.next != null){
            tailA = tailA.next;
            len++;
        }
        len++;
        while(tailB.next != null){
            tailB = tailB.next;
            len++;
        }
        int i = 1;
        ListNode curA = headA;
        ListNode curB = headB;
        while(i<=len){
            if(curA == curB){
                return curA;
            } else {
                if(curA == tailA){
                    curA = headB;
                } else {
                    curA = curA.next;
                }

                if(curB == tailB){
                    curB = headA;
                } else {
                    curB = curB.next;
                }
            }
        }

        return null;
    }
}
