package baodian;

import leetcode.ListNode;

public class Ques0203 {


    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = new ListNode(-1);
        pre.next = cur;
        while (cur.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
    }
}
