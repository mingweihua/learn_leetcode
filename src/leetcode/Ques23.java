package leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Ques23 {

	public static void main(String[] args) {

	}
	
	
	//使用TreeMap思路很好，但是key值不唯一，重复的值都没了，如果用TreeSet，字符串的排序不一定正确
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1 && lists[0] == null) {
			return null;
		}
		ListNode newHead = new ListNode(-1);
		ListNode cur = newHead;
		TreeSet<String> sortedSet = new TreeSet<String>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				sortedSet.add(""+lists[i].val + "_" + i);
			}
		}
		while (!sortedSet.isEmpty()) {
			String first = sortedSet.first();
			int j = Integer.valueOf(first.split("_")[1]);
			sortedSet.remove(first);
			ListNode temp = lists[j];
			lists[j] = lists[j].next;
			temp.next = null;
			cur.next = temp;
			cur = cur.next;
			if (lists[j] != null) {
				sortedSet.add(""+lists[j].val + "_" + j);
			}
		}
		return newHead.next;
	}
	
	private ArrayList<ListNode> resList = new ArrayList<ListNode>();
	//两个两个合并
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				resList.add(lists[i]);
			}
		}
		if(resList.size() == 0) {
			return null;
		}
		while(resList.size()!=1) {
			ListNode list1 = resList.remove(0);
			ListNode list2 = resList.remove(0);
			mergeList(list1,list2);
		}
		return resList.get(0);
	}
	
	public void mergeList(ListNode list1, ListNode list2) {
		ListNode newHead = new ListNode(-1);
		ListNode cur = newHead;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				cur.next = list1;
				list1 = list1.next;
				cur = cur.next;
				cur.next = null;
			} else {
				cur.next = list2;
				list2 = list2.next;
				cur = cur.next;
				cur.next = null;
			}
		}

		while (list1 != null) {
			cur.next = list1;
			list1 = list1.next;
			cur = cur.next;
			cur.next = null;
		}
		
		while (list2 != null) {
			cur.next = list2;
			list2 = list2.next;
			cur = cur.next;
			cur.next = null;
		}
		
		resList.add(newHead.next);
	}
}
