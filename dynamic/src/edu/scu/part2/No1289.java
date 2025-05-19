package edu.scu.part2;

public class No1289 {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length-1;i++){
            for (int j=0;j<grid[0].length;j++){
                dp[i][j]+=grid[i][j];
                for (int k=0;k<grid[0].length;k++){
                    if (k!=j){
                        dp[i+1][k]=dp[i+1][k]==0?dp[i][j]:Math.min(dp[i+1][k],dp[i][j]);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<grid[0].length;i++){
            min=Math.min(min,dp[grid.length-1][i]+grid[grid.length-1][i]);
        }
        return min;
    }
}
