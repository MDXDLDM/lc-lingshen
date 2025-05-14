package edu.scu.mytrie;

import java.util.*;
import java.util.function.Consumer;

public class WordFilter {
    public WordFilter(String[] words) {
        int index=0;
        for (String word : words) {
            Node cur=root;
            for (char c : word.toCharArray()) {
                int i=c-'a';
                if (cur.children[i]==null) {
                    cur.children[i]=new Node();
                }
                cur.list.add(index);
                cur=cur.children[i];
            }
            cur.list.add(index);
            cur=backroot;
            for (int i=word.length()-1;i>=0;i--) {
                int j=word.charAt(i)-'a';
                if (cur.children[j]==null) {
                    cur.children[j]=new Node();
                }
                cur.list.add(index);
                cur=cur.children[j];
            }
            cur.list.add(index);
            index++;
        }
    }

    public int f(String pref, String suff) {
        Node cur=root;
        for (char c : pref.toCharArray()) {
            int i=c-'a';
            if (cur.children[i]==null) {
                return -1;
            }
            cur=cur.children[i];
        }
        List<Integer> temp=cur.list;
        if (temp.isEmpty()) {
            return -1;
        }
        Node curr=backroot;
        for (int i=suff.length()-1;i>=0;i--) {
            int j=suff.charAt(i)-'a';
            if (curr.children[j]==null) {
                return -1;
            }
            curr=curr.children[j];
        }
        List<Integer> temp2=curr.list;
        if (temp2.isEmpty()) {
            return -1;
        }
        int first=temp.size()-1;
        int second=temp2.size()-1;
        while(first>=0&&second>=0) {
            int a=temp.get(first);
            int b=temp2.get(second);
            if (a<b) {
                second--;
            }else if (a>b) {
                first--;
            }else{
                return a;
            }
        }
        return -1;
    }
    private static class Node{
        Node[] children=new Node[26];
        List<Integer> list=new LinkedList<>();
    }
    private final Node root=new Node();
    private final Node backroot=new Node();
}
