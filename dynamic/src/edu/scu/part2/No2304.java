package edu.scu.part2;

public class No2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp=new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int num=grid[i][j];
                dp[i][j]+=num;
                for (int k=0;k<grid[0].length;k++) {
                    int value=moveCost[num][k];
                    dp[i+1][k]=dp[i+1][k]==0?value+dp[i][j]:Math.min(dp[i+1][k],value+dp[i][j]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<grid[0].length;i++) {
            min=Math.min(min,dp[grid.length-1][i]+grid[grid.length-1][i]);
        }
        return min;
    }
}
