package edu.scu.mytrie;

import java.util.ArrayList;
import java.util.List;

public class No140 {
    List<String> path=new ArrayList<>();
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            Node cur=root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.isend=true;
            cur.word=word;
        }
        deepsearch(s,0);
        return result;
    }
    private static class Node{
        Node[] children=new Node[26];
        boolean isend;
        String word;
    }
    private final Node root=new Node();

    private void deepsearch(String s,int index){
        Node cur=root;
        for (int i=index;i<s.length();i++){
            int pos=s.charAt(i)-'a';
            if (cur.children[pos]==null){
                return;
            }
            System.out.println(cur.word);
            cur=cur.children[pos];
            if (cur.isend){
                path.add(cur.word);
                deepsearch(s, i+1);
                path.remove(path.size()-1);
            }
        }
        if (index==s.length()&&!path.isEmpty()){
            StringBuilder sb=new StringBuilder();
            for (String word : path){
                sb.append(word);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
        }
    }
}
