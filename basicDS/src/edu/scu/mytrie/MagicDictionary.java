package edu.scu.mytrie;

public class MagicDictionary {
    private static class Node{
        Node[] children=new Node[26];
        boolean isend;
    }
    private final Node root=new Node();
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node cur=root;
            for (char c : word.toCharArray()) {
                int index=c-'a';
                if (cur.children[index]==null){
                    cur.children[index]=new Node();
                }
                cur=cur.children[index];
            }
            cur.isend=true;
        }
    }

    public boolean search(String searchWord) {
        Node cur=root;
        int i=0;
        for (char c : searchWord.toCharArray()) {
            int index=c-'a';
            String nextWord=searchWord.substring(i+1);
            for (int j=0;j<26;j++) {
                if (cur.children[j]==null||j==index) continue;
                if (research(nextWord,cur.children[j])){
                    return true;
                }
            }
            cur=cur.children[index];
            if (cur==null) return false;
            i++;
        }
        return false;
    }

    private boolean research(String word,Node cur) {
        for (char c : word.toCharArray()) {
            int index=c-'a';
            if (cur.children[index]==null){
                return false;
            }
            cur=cur.children[index];
        }
        return cur.isend;
    }
}
