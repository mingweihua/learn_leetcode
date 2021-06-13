package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Ques146 {

	
	private LinkedHashMap<Integer,Integer> dataMap;
    private int size = 0;
    private int capacity = 0;

    public Ques146(int capacity) {
    	this.dataMap = new LinkedHashMap<Integer,Integer>();
        this.capacity = capacity;
        this.size = 0;
        
    }
    
    public int get(int key) {
        if(size != 0 &&  dataMap.containsKey(key)){
            int value = dataMap.remove(key);
            size--;
            put(key,value);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(dataMap.containsKey(key)){
        	dataMap.remove(key);
            dataMap.put(key,value);
            return;
        }
        if(size < capacity){
            dataMap.put(key,value);
            size++;
        } else {
        	Iterator<Integer> it = dataMap.keySet().iterator();
        	int oldkey = it.next();
        	dataMap.remove(oldkey);
        	dataMap.put(key,value);
        }
    }
    
}
