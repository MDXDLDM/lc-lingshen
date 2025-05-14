package edu.scu.mytrie;

public class No3093 {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            Node cur=root;
            int len=word.length();
            for (int j=len-1;j>=0;j--) {
                int index = word.charAt(j) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index]=new Node();
                }
                if (len<cur.max){
                    System.out.println(cur.max);
                    cur.max=len;
                    cur.index=i;
                    System.out.println(cur.max);
                }
                cur = cur.children[index];
            }
            if (len<cur.max){
                cur.max=len;
                cur.index=i;
            }
        }
        for (int i = 0; i < wordsQuery.length; i++) {
            String word = wordsQuery[i];
            Node cur=root;
            int num= wordsContainer.length;
            for (int j=word.length()-1;j>=0;j--) {
                int index=word.charAt(j) - 'a';
                if (cur.children[index] == null) {
                    num=Math.min(num,cur.index);
                    break;
                }
                cur = cur.children[index];
            }
            num=Math.min(num,cur.index);
            res[i]=num;
        }
        return res;
    }
    private static class Node{
        Node[] children = new Node[26];
        int max=Integer.MAX_VALUE;
        int index=Integer.MAX_VALUE;
    }
    private final Node root=new Node();
}
