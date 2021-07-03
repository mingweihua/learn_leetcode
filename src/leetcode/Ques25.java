package leetcode;

public class Ques25 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode newHead = new Ques25().reverseKGroup(node1,2);
		while (newHead!=null){
			System.out.print(newHead.val+",");
			newHead = newHead.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(k<=1){
			return head;
		}
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		ListNode c_start = newHead;
		ListNode c_send = c_start;
		int num = 0;
		while (c_send != null) {
			num = k;
			while(num>0 && c_send != null) {
				c_send = c_send.next;
				num--;
			};
			if(c_send == null){
				//reverse(c_start);
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
