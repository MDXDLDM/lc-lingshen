package edu.scu.graphic;

public class Trie {
    private static class Node{
        Node[] characters=new Node[26];
        boolean isend=false;
    }
    private final Node root=new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node cur=root;
        for(char c:word.toCharArray()) {
            int index=c-'a';
            if (cur.characters[index]==null){
                cur.characters[index]=new Node();
            }
            cur=cur.characters[index];
        }
        cur.isend=true;
    }

    public boolean search(String word) {
        return find(word)==1;
    }

    public boolean startsWith(String prefix) {
        return find(prefix)!=0;
    }
    private int find(String word) {
        Node cur=root;
        for(char c:word.toCharArray()) {
            int index=c-'a';
            if (cur.characters[index]==null){
                return 0;//不存在
            }
            cur=cur.characters[index];
        }
        return cur.isend?1:2;//word-1  prefix-2
    }
}
