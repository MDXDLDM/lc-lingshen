package edu.scu.part2;

public class No2684 {
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length];
        for (int i = 1; i <= grid.length; i++) {
            dp[i][0] = 1;
        }
        int max=0;
        for (int i=1;i<grid[0].length;i++){
            for (int j=0;j<grid.length;j++){
                //dp[j+1][i]
                int temp=0;
                if(grid[j][i]>grid[j][i-1]){
                    temp=Math.max(temp,dp[j+1][i-1]);
                }
                if (j>0&&grid[j][i]>grid[j-1][i-1]){
                    temp=Math.max(temp,dp[j][i-1]);
                }
                if (j<grid.length-1&&grid[j][i]>grid[j+1][i-1]){
                    temp=Math.max(temp,dp[j+2][i-1]);
                }
                if (temp!=0){
                    max=Math.max(max,temp+1);
                    dp[j+1][i]=temp+1;
                }
            }
        }
        return Math.max(0,max-1);
    }
}
