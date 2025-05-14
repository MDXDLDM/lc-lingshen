package edu.scu.mytrie;

public class No2416 {
    public int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        for(String word : words){
            insert(word);
        }
        Node temp=root;
        int score=0;int u=0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                int index=c-'a';
                if (temp.children[index] == null) {
                    break;
                }
                score+=temp.children[index].count;
                temp=temp.children[index];
            }
            temp=root;
            result[u++]=score;
            score=0;
        }
        return result;
    }
    private static class Node{
        Node[] children = new Node[26];
        int count=1;
    }
    private final Node root = new Node();
    private void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index=c-'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }else{
                curr.children[index].count++;
            }
            curr = curr.children[index];
        }
    }
}
