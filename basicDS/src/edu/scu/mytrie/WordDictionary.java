package edu.scu.mytrie;

public class WordDictionary {
    private static class Node{
        Node[] children=new Node[26];
        boolean isend;
    }
    private final Node root=new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
        Node cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null){
                cur.children[index]=new Node();
            }
            cur=cur.children[index];
        }
        cur.isend=true;
    }

    public boolean search(String word) {
        return find(word,root);
    }
    private boolean find(String word,Node cur){
        for(int i=0;i<word.length();i++){
            if (word.charAt(i)=='.'){
                boolean end=false;
                for (Node child:cur.children){
                    if (child!=null){
                        String w=word.substring(i+1);
                        //System.out.println(w);
                        end=end||find(w,child);
                    }
                }
                return end;
            }else{
                int index=word.charAt(i)-'a';
                if(cur.children[index]==null){
                    return false;
                }
                cur=cur.children[index];
            }
        }
        return cur.isend;
    }
}
