package edu.scu.mytrie;

import java.util.Arrays;

public class No720 {
    public String longestWord(String[] words) {
        root.isend=true;
        Arrays.sort(words);
        String res=null;
        for (String word : words) {
            String temp=insert(word);
            if (temp!=null){
                res=temp;
            }
        }
        return res==null?"":res;
    }
    private static class Node{
        Node[] children = new Node[26];
        boolean isend;
    }
    private final Node root = new Node();
    private int max=0;
    public String insert(String word) {
        int count=0;boolean flag=true;
        StringBuilder sb=new StringBuilder();
        Node cur=root;
        for(char c:word.toCharArray()) {
            int index=c-'a';
            if (cur.children[index]==null){
                cur.children[index]=new Node();
            }
            if (!cur.isend){
                flag=false;
            }
            sb.append(c);
            count++;
            cur=cur.children[index];
        }
        cur.isend=true;
        if (count>max&&flag){
            max=count;
            return sb.toString().trim();
        }
        return null;
    }
}
