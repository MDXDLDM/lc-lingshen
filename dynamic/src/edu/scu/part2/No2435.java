package edu.scu.part2;

public class No2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length+1][grid[0].length+1][k];
        dp[0][1][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int value= grid[i][j];
                for (int m=0;m<k;m++){
                    int n=(m+value)%k;
                    dp[i+1][j+1][n]=(dp[i+1][j][m]+dp[i][j+1][m])%1000000007;
                }
                //System.out.println(dp[i+1][j+1][0]);
            }

        }
        return dp[grid.length][grid[0].length][0];
    }
}
