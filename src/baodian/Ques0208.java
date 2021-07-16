package baodian;

import leetcode.ListNode;

public class Ques0208 {


    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
