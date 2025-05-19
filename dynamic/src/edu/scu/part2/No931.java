package edu.scu.part2;

public class No931 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+2];
        for (int i=0;i<matrix.length;i++){
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][matrix[0].length+1]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i+1][j+1]=Math.min(Math.min(dp[i][j],dp[i][j+1]),dp[i][j+2])+matrix[i][j];
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i = 1; i <= matrix[0].length; i++) {
            System.out.println(dp[matrix.length][i]);
            res=Math.min(res,dp[matrix.length][i]);
        }
        return res;
    }
}
