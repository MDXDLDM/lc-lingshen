package edu.scu.mytrie;

import java.util.List;

public class No648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String temp=find(word);
            System.out.println(temp);
            if (temp!=null) sb.append(temp).append(" ");
            else sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
    private static class Node{
        Node[] characters=new Node[26];
        boolean isend=false;
    }
    private final Node root=new Node();

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
    public String find(String word) {
        Node cur=root;
        StringBuilder sb=new StringBuilder();
        for(char c:word.toCharArray()) {
            if (cur.characters[c-'a']==null){
                return null;
            }
            sb.append(c);
            cur=cur.characters[c-'a'];
            if (cur.isend){
                //System.out.println("yes");
                return sb.toString();
            }
        }
        return null;
    }
}
