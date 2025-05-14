package edu.scu.mytrie;

import java.util.HashMap;

public class MapSum {
    private static class Node{
        Node[] children=new Node[26];
        int score=0;
    }
    private final Node root=new Node();
    HashMap<String,Integer> map;
    public MapSum() {
        map=new HashMap<>();
    }

    public void insert(String key, int val) {
        int min=0;
        if(map.containsKey(key)) {
            min=map.get(key);
        }
        map.put(key,val);
        Node cur=root;
        for(char c:key.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null){
                cur.children[index]=new Node();
            }
            cur.children[index].score+=(val-min);
            cur=cur.children[index];
        }
    }

    public int sum(String prefix) {
        Node cur=root;
        int sum=0;
        for (char c:prefix.toCharArray()) {
            int index=c-'a';
            if(cur.children[index]==null){
                return 0;
            }
            cur=cur.children[index];
        }
        return cur.score;
    }
}
