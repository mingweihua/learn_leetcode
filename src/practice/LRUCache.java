package practice;


import java.util.HashMap;

public class LRUCache  {

    private HashMap<Integer,Node> map;
    private int cap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        //哨兵头节点和尾节点
        Node node1 = new Node();
        Node node2 = new Node();
        head = node1;
        tail = node2;
        node1.next = node2;
        node2.pre = node1;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        } else {
            moveToTail(node);
            return node.value;
        }
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        map.put(key,node);

        node.pre = tail.pre;
        node.pre.next = node;

        node.next = tail;
        tail.pre = node;

        if(map.size()>cap){
            removeOldest();
        }
    }

    public void moveToTail(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.pre = tail.pre;
        node.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }


    public void removeOldest(){
        if(map.size()==0){
            return;
        }
        Node node = head.next;
        map.remove(node.key);
        head.next = node.next;
        head.next.pre = head;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }


}
