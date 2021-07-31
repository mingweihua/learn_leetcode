package key.LRU_LFU;

import java.util.HashMap;
import java.util.LinkedList;

/*
    这是根据答案得双hash表来做的，但是时间运行还是挺慢的，自己的写一个双链表排序反而更快
 */
public class LFUCache  {

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
        lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lFUCache.get(1));      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        System.out.println(lFUCache.get(2));
        System.out.println(lFUCache.get(3));

    }


    int capacity;
    HashMap<Integer,Node> keyMaps;
    HashMap<Integer, LinkedList<Node>> timesMaps;
    int n;
    int minTimes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMaps = new HashMap<>(capacity);
        timesMaps = new HashMap<>(capacity);
        n = 0;
        minTimes = 0;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyMaps.containsKey(key)){
            return -1;
        }
        Node node = keyMaps.get(key);
        LinkedList list1 =  timesMaps.get(node.times);
        list1.remove(node);
        if(minTimes == node.times && list1.size() == 0){
            timesMaps.remove(minTimes);
            minTimes++;
        }
        node.times++;
        LinkedList list2 = timesMaps.getOrDefault(node.times,new LinkedList<>());
        list2.addFirst(node);
        timesMaps.put(node.times,list2);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if(keyMaps.containsKey(key)){
            Node node = keyMaps.get(key);
            LinkedList list1 =  timesMaps.get(node.times);
            list1.remove(node);
            if(minTimes == node.times && list1.size() == 0){
                timesMaps.remove(minTimes);
                minTimes++;
            }

            node.times++;
            node.val = value;

            LinkedList list2 = timesMaps.getOrDefault(node.times,new LinkedList<>());
            list2.addFirst(node);
            timesMaps.put(node.times,list2);
        } else {
            if(n == capacity){
                Node old = timesMaps.get(minTimes).removeLast();
                keyMaps.remove(old.key);
                n--;
            }

            Node node = new Node(value,key,1);

            keyMaps.put(key,node);
            LinkedList list2 = timesMaps.getOrDefault(1,new LinkedList<>());
            list2.addFirst(node);
            timesMaps.put(1,list2);
            minTimes = 1;
            n++;
        }
    }

    class Node {
        int val;
        int key;
        int times;

        public Node(int val, int key, int times) {
            this.val = val;
            this.key = key;
            this.times = times;
        }
    }
}
