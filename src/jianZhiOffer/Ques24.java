package jianZhiOffer;

import leetcode.ListNode;

public class Ques24 {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    //答案的位运算优化
    /*
        多少个1只要计算多少次，比从左到右逐个判断是否是1时间上更短
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur =head;
        ListNode next =cur.next;
        while (cur!=null){
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
            next = next.next;
        }
        return newHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
