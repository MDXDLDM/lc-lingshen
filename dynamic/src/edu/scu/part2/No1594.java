package edu.scu.part2;

public class No1594 {
    public int maxProductPath(int[][] grid) {
        long[][][] dp=new long[grid.length+1][grid[0].length+1][2];
        for(int i=1;i<=grid[0].length;i++){
            dp[0][i][0]=Integer.MIN_VALUE;
            dp[0][i][1]=Integer.MAX_VALUE;
        }
        for (int i=1;i<=grid.length;i++){
            dp[i][0][0]=Integer.MIN_VALUE;
            dp[i][0][1]=Integer.MAX_VALUE;
        }
        dp[0][1][0]=1;
        dp[0][1][1]=1;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int value=grid[i][j];
                long max=Math.max(dp[i+1][j][0],dp[i][j+1][0])*value;
                long min=Math.min(dp[i+1][j][1],dp[i][j+1][1])*value;
                if (value>=0){
                    dp[i+1][j+1][0]=max;
                    dp[i+1][j+1][1]=min;
                }else{
                    dp[i+1][j+1][0]=min;
                    dp[i+1][j+1][1]=max;
                }
                System.out.println(dp[i+1][j+1][0]+" "+dp[i+1][j+1][1]);
            }
        }
        if (dp[grid.length][grid[0].length][0]<0){
            return -1;
        }
        return (int)(dp[grid.length][grid[0].length][0]%1000000007);
    }
}
