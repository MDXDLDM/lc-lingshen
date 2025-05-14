package edu.scu.mytrie;

import java.util.*;

public class No1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<String>();
        Arrays.sort(folder);
        for (String s : folder) {
            String[] temp = s.split("/");
            if (insert(temp)){
                list.add(s);
            }
        }
        return list;
    }
    private static class Node{
        HashMap<String,Node> children=new HashMap<>();
        boolean isend;
    }
    private final Node root=new Node();
    private boolean insert(String[] s){
        Node cur=root;
        for (String c:s) {
            if (c==null) continue;
            if (cur.children.containsKey(c)){
                System.out.println("contains");
                if (cur.children.get(c).isend){
                    return false;
                }
            }else{
                cur.children.put(c, new Node());
            }
            cur=cur.children.get(c);
        }
        cur.isend=true;
        return true;
    }
}
