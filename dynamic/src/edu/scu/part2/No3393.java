package edu.scu.part2;

public class No3393 {
    private int res=0;
    private static int mod=1000000007;
    private int k;
    private int row;
    private int col;
    public int countPathsWithXorValue(int[][] grid, int k) {
//        this.k=k;
//        row=grid.length;
//        col=grid[0].length;
//        dfs(0,0,grid,grid[0][0]);
//
//        return res;
        int maxValue=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxValue = Math.max(maxValue, grid[i][j]);
            }
        }
        int maxWithall1=1<<(32-Integer.numberOfLeadingZeros(maxValue));
        if (maxWithall1<=k){
            return 0;
        }
        int[][][] dp=new int[grid.length+1][grid[0].length+1][maxWithall1];
        dp[0][1][0]=1;
        //dp[1][0][0]=1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int p=0;p<maxWithall1;p++) {
                    int value=p^grid[i][j];
                    dp[i+1][j+1][value]+=dp[i+1][j][p];
                    dp[i+1][j+1][value]+=dp[i][j+1][p];
                    dp[i+1][j+1][value]%=mod;
                }
            }
        }
        return dp[grid.length][grid[0].length][k];
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
