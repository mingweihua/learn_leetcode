package baodian;

import leetcode.ListNode;

public class Ques0204 {


    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode right = head;
        while (right!=null && right.val<x){
            right = right.next;
        }
        if(right == null){
            return head;
        }
        ListNode pre = right;
        ListNode cur = right.next;
        while (cur!=null){
            if(cur.val<x){
                pre.next = cur.next;
                cur.next = newHead.next;
                newHead.next = cur;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return newHead.next;
    }
}
