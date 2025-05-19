package edu.scu.part2;

import java.util.Arrays;

public class No3418 {
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length+1][coins[0].length+1][3];
        //0 1 2代表感化了x次
        for (int i=1;i<=coins[0].length;i++){
            dp[0][i][0]=Integer.MIN_VALUE;
            dp[0][i][1]=Integer.MIN_VALUE;
            dp[0][i][2]=Integer.MIN_VALUE;
        }
        for (int i=1;i<=coins.length;i++){
            dp[i][0][0]=Integer.MIN_VALUE;
            dp[i][0][1]=Integer.MIN_VALUE;
            dp[i][0][2]=Integer.MIN_VALUE;
        }
        //使得dp11能够被初始化
        Arrays.fill(dp[0][1],0);
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[0].length; j++) {
                int value=coins[i][j];
                dp[i+1][j+1][0]=Math.max(dp[i+1][j][0],dp[i][j+1][0])+value;
                dp[i+1][j+1][1]=Math.max(Math.max(dp[i+1][j][1],dp[i][j+1][1])+value,Math.max(dp[i+1][j][0],dp[i][j+1][0]));
                dp[i+1][j+1][2]=Math.max(Math.max(dp[i+1][j][2],dp[i][j+1][2])+value,Math.max(dp[i+1][j][1],dp[i][j+1][1]));
            }
        }
        //认为感化两次是最大的
        return dp[coins.length][coins[0].length][2];
    }
}
