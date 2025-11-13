package edu.scu.linkedList;

import java.util.*;

public class LRUCache {
    //自己实现LinkedHashMap，维护一个双向链表和map
    int capacity;
    int size=0;
    Queue<Integer> key;
    Map<Integer, Integer> entry;
    Map<Integer, Integer> delete;
    public LRUCache(int capacity) {
        key = new LinkedList<>();
        entry=new HashMap<>();
        delete=new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (entry.containsKey(key)) {
            put(key, entry.get(key));
            return entry.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(entry.containsKey(key)){
            delete.put(key,delete.getOrDefault(key,0)+1);
        }else{
            size++;
            if(size>capacity){
                delete();
            }
        }
        this.key.offer(key);
        entry.put(key,value);
    }
    public void delete() {
        int key;
        while(true){
            key = this.key.poll();
            if(delete.containsKey(key)){
                delete.put(key,delete.get(key)-1);
                if(delete.get(key)==0){
                    delete.remove(key);
                }
            }else{
                break;
            }
        }
        entry.remove(key);
        size--;
    }
}
