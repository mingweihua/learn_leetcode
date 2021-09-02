package jianZhiOffer;

import leetcode.ListNode;

public class Ques22 {


    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (k>0 && cur!=null){
            cur = cur.next;
            k--;
        }
        if(cur == null && k >0){
            return null;
        }
        ListNode pre = head;
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }

}
