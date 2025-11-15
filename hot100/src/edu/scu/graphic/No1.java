package edu.scu.graphic;

public class No1 {
    private static final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] isVisited;
    int count=0;
    public int numIslands(char[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isVisited[i][j]) continue;
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col) {
        if (isVisited[row][col]) return;
        isVisited[row][col] = true;
        for(int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow>=0&&newRow< grid.length&&newCol>=0&&newCol<grid[0].length&&grid[newRow][newCol]=='1'&&!isVisited[newRow][newCol]) {
                dfs(grid, newRow, newCol);
            }
        }
    }
}
