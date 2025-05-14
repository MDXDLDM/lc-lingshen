package edu.scu.mytrie;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class No1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        for (String product : products) {
            insert(product);
        }
        Node cur=root;
        boolean con=true;
        for (int i = 0; i < searchWord.length(); i++) {
            int index=searchWord.charAt(i)-'a';
            List<String> list=new ArrayList<>();
            if (con&&cur.children[index]!=null) {
                TreeSet<String> set=cur.children[index].set;
                if (set.size()>3){
                    String[] arr=set.toArray(new String[set.size()]);
                    list.add(arr[0]);list.add(arr[1]);list.add(arr[2]);
                }else{
                    list.addAll(set);
                }
                cur=cur.children[index];
            }else{
                con=false;
            }
            result.add(list);
        }
        return result;
    }
    private static class Node{
        Node[] children = new Node[26];
        TreeSet<String> set= new TreeSet<>();
    }
    private final Node root=new Node();
    private void insert(String word){
        Node cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null){
                cur.children[index]=new Node();
            }
            cur.children[index].set.add(word);
            cur=cur.children[index];
        }
    }
}
