package edu.scu.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No8 {
    List<List<String>> list=new ArrayList<>();
    List<String> path=new ArrayList<>();
    //StringBuilder sb=new StringBuilder();
    boolean[] cols;
    public List<List<String>> solveNQueens(int n) {
        cols=new boolean[n];
        boolean[][] board=new boolean[n][n];
        dfs(board,0);
        return list;
    }
    public void dfs(boolean[][] board,int row) {
        if (row==board.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (canPut(board,row,i)&&!cols[i]) {
                board[row][i]=true;
                String temp=getString(board.length,i);
                //sb.delete(0,sb.length());
                path.add(temp);
                cols[i]=true;
                dfs(board,row+1);
                path.remove(path.size()-1);
                cols[i]=false;
                board[row][i]=false;
            }
        }
    }
    private boolean canPut(boolean[][] board,int row,int col) {
        int n=board.length;
        int i=row-1;int j=col-1;
        while(i>=0&&j>=0){
            if(board[i][j]){
                return false;
            }
            i--;j--;
        }
        i=row-1;j=col+1;
        while(i>=0&&j<n){
            if(board[i][j]){
                return false;
            }
            i--;j++;
        }
        return true;
    }
    private String getString(int n,int index){
        char[] c=new char[n];
        Arrays.fill(c,'.');
        c[index]='Q';
        return new String(c);
    }
}
