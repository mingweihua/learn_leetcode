package leetcode;

import java.util.HashMap;

public class Ques138 {



    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node newPre = new Node(head.val);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(head,newPre);
        Node cur = head.next;
        Node newNode = null;
        while (cur != null){
            newNode = new Node(cur.val);
            newPre.next = newNode;
            map.put(cur,newNode);
            cur = cur.next;
            newPre = newPre.next;
        }
        cur = head;
        while (cur!=null){
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
