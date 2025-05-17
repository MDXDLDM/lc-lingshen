package edu.scu.part2;

public class No3393 {
    private int res=0;
    private static int mod=1000000007;
    private int k;
    private int row;
    private int col;
    public int countPathsWithXorValue(int[][] grid, int k) {
        this.k=k;
        row=grid.length;
        col=grid[0].length;
        dfs(0,0,grid,grid[0][0]);

        return res;
    }
    private void dfs(int row,int col,int[][] grid,int cur) {
        if (row==this.row && col==this.col){
            if (cur==k){
                res++;
                res%=mod;
            }
            return;
        }
        if (row< this.row-1){
            dfs(row+1,col,grid,cur^grid[row+1][col]);
        }
        if (col<this.col-1){
            dfs(row,col+1,grid,cur^grid[row][col+1]);
        }
    }
}
