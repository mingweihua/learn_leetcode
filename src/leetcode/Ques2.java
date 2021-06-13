package leetcode;


public class Ques2 {
	
	/***
	 * 
	 * @param 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
		输出：7 -> 0 -> 8
		原因：342 + 465 = 807
	 */
	public static void main(String[] args) {
		
		
	}

	public static ListNode twoSum(ListNode l1, ListNode l2) {
		int code = 0;
		ListNode sumList;
		if (l1.val+l2.val < 10) {
			sumList = new ListNode(l1.val + l2.val);
			code = 0;
		} else {
			sumList = new ListNode((l1.val + l2.val) % 10);
			code = 1;
		}
		ListNode nextNode = sumList;
		while (l1.next!=null && l2.next!=null) {
			if (l1.next.val + l2.next.val + code < 10) {
				nextNode.next = new ListNode(l1.next.val + l2.next.val + code);
				code = 0;
			} else {
				nextNode.next = new ListNode((l1.next.val + l2.next.val + code) % 10);
				code = 1;
			}		
			nextNode = nextNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1.next!=null) {
			if (l1.next.val + code < 10) {
				nextNode.next = new ListNode(l1.next.val + code);
				code = 0;
			} else {
				nextNode.next = new ListNode((l1.next.val + code) % 10);
				code = 1;
			}	
			nextNode = nextNode.next;
			l1 = l1.next;
		}
		while (l2.next!=null) {
			if (l2.next.val + code < 10) {
				nextNode.next = new ListNode(l2.next.val + code);
				code = 0;
			} else {
				nextNode.next = new ListNode((l2.next.val + code) % 10);
				code = 1;
			}	
			nextNode = nextNode.next;
			l2 = l2.next;
		}
		if (code != 0) {
			nextNode.next = new ListNode(code);
			nextNode = nextNode.next;
		}
		return sumList;
	}
	
	
	//标准答案
	public static ListNode twoSum2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}