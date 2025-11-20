package edu.scu.backtrack;

public class No6 {
    private static final int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        //可优化
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag=dfs(board,visited,word,1,i,j);
                    if (flag) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, String word, int index,int row,int col) {
        if (index == word.length()) {
            return true;
        }
        visited[row][col] = true;
        for(int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(newRow>=0&&newRow<board.length&&newCol>=0&&newCol<board[0].length&&board[newRow][newCol]==word.charAt(index)&&!visited[newRow][newCol]) {
                if (dfs(board,visited,word,index+1,newRow,newCol)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
