package baodian;

import leetcode.ListNode;

public class Ques0205 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre1 = l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int temp = 0;
        int incre = 0;
        while (cur1 !=null && cur2 != null){
            temp = cur1.val + cur2.val + incre;
            incre = temp / 10;
            cur1.val = temp % 10;
            pre1 = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 !=null){
            temp = cur1.val + incre;
            incre = temp / 10;
            cur1.val = temp % 10;
            pre1 = pre1.next;
            cur1 = cur1.next;
        }
        if(cur2 !=null){
            pre1.next = cur2;
            while (cur2 !=null){
                temp = cur2.val + incre;
                incre = temp / 10;
                cur2.val = temp % 10;
                pre1 = pre1.next;
                cur2 = cur2.next;
            }
        }

        if(incre!=0){
            ListNode newTail = new ListNode(incre);
            pre1.next = newTail;
        }
        return l1;
    }
}
