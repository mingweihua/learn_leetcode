package shopee;

import leetcode.ListNode;

public class Ques202106 {
    public static void main(String[] args) {

    }

    public ListNode reverseLinkedList (ListNode head, int n) {
        if(n<=1){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode c_start = newHead;
        ListNode c_send = c_start;
        int num = 0;
        while (c_send != null) {
            num = n;
            while(num>0 && c_send != null) {
                c_send = c_send.next;
                num--;
            };
            if(c_send == null){
                reverse(c_start);
                break;
            }
            if(num==0){
                c_start = reverse(c_start,c_send);
                c_send = c_start;
            }
        }
        return newHead.next;
    }

    public void reverse(ListNode pre){
        if(pre==null || pre.next == null){
            return;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        while (next != null){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = cur.next;
        }
        return;
    }

    public ListNode reverse(ListNode pre, ListNode end){

        ListNode cur = pre.next;
        ListNode next = cur.next;
        while (next != end){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = cur.next;
        }
        cur.next = next.next;
        next.next = pre.next;
        pre.next = next;

        return cur;
    }

}
