package baodian;

import leetcode.ListNode;

import java.util.HashSet;

public class Ques0201 {


    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null){
            if(set.contains(cur.val)){
                cur = cur.next;
                pre.next = cur;
            } else {
                set.add(cur.val);
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
