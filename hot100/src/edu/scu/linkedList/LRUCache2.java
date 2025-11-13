package edu.scu.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    private static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(){

        }
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer,Node> map;
    int capacity;
    Node dummy=new Node();
    public LRUCache2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            front(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(get(key)!=-1){
            //已经remove and front
            map.get(key).value = value;
        }else{
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            front(newNode);
        }
        if(map.size()>capacity){
            Node last=dummy.prev;
            map.remove(last.key);
            remove(last);
        }
    }
    private void front(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
