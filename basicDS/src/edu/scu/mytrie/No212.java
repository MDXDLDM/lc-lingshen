package edu.scu.mytrie;

import java.util.ArrayList;
import java.util.List;

public class No212 {
    private List<String> list=new ArrayList<>();
    private static int[][] pos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private boolean[][] visited;
    private char[][] graph;
//    private static StringBuilder sb=new StringBuilder();
    public List<String> findWords(char[][] board, String[] words) {
        visited=new boolean[board.length][board[0].length];
        graph=board;
        for(String word : words){
            Node cur=dicroot;
            for(char c : word.toCharArray()){
                int index=c-'a';
                if (cur.children[index]==null){
                    cur.children[index]=new Node();
                }
                cur=cur.children[index];
            }
            cur.isend=true;
            cur.word=word;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Node cur=dicroot;
                search(i,j,cur);
            }
        }

        return list;
    }
    private static class Node{
        String word;
        Node[] children = new Node[26];
        boolean isend;
    }
    private final Node dicroot = new Node();
    private void search(int row, int col,Node cur){
        char c=graph[row][col];
        if (cur.children[c-'a']==null){
            return;
        }
        visited[row][col]=true;
//        sb.append(c);
        cur=cur.children[c-'a'];
        if (cur.isend){
            String str=cur.word;
            if (!list.contains(str)){
                list.add(str);
            }
        }
        for (int i=0;i<4;i++){
            int newRow = row+pos[i][0];
            int newCol = col+pos[i][1];
            if (newRow>=0&&newRow<graph.length&&newCol>=0&&newCol<graph[0].length&&!visited[newRow][newCol]){
                search(newRow,newCol,cur);
            }
        }
//        sb.deleteCharAt(sb.length()-1);
        visited[row][col]=false;
    }
}
