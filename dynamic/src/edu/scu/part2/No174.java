package edu.scu.part2;

public class No174 {
    private int min=0;
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp=new int[dungeon.length+1][dungeon[0].length+1];
        for(int i=0;i<dungeon.length;i++){
            dp[i][dungeon[0].length]=Integer.MAX_VALUE;
        }
        for(int i=0;i<dungeon[0].length;i++){
            dp[dungeon.length][i]=Integer.MAX_VALUE;
        }
        dp[dungeon.length][dungeon[0].length-1]=1;
        dp[dungeon.length-1][dungeon[0].length]=1;
        for (int i=dungeon.length-1;i>=0;i--){
            for (int j=dungeon[0].length-1;j>=0;j--){
                //dp[i][j]从ij到终点需要的点数
                int min=Math.min(dp[i+1][j],dp[i][j+1]);
                //如果结果为负，代表不需要前置点数即可走到这里，则设置为最小需求1
                dp[i][j]=Math.max(1,min-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
    private void dfs(int[][] dungeon,int row,int col,int sum){
        if (row==dungeon.length-1 && col==dungeon[0].length-1){
            if (sum<0){
                if (min==0||sum>min){
                    min=sum;
                }
            }
            return;
        }
        if (row<dungeon.length-1){
            dfs(dungeon,row+1,col,sum+dungeon[row+1][col]);
        }
        if (col<dungeon[0].length-1){
            dfs(dungeon,row,col+1,sum+dungeon[row][col+1]);
        }
    }
}
