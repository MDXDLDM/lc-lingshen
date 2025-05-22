package edu.scu.part2;

public class No174 {
    private int min=0;
    public int calculateMinimumHP(int[][] dungeon) {
        int[][][] dp=new int[dungeon.length+1][dungeon[0].length+1][2];
        int min=0;
        for (int i=1;i<=dungeon.length;i++){
            dp[i][0][0]=Integer.MIN_VALUE;
        }
        for (int j=2;j<=dungeon[0].length;j++){
            dp[0][j][0]=Integer.MIN_VALUE;
        }
        for (int i=0;i<dungeon.length;i++){
            for (int j=0;j<dungeon[0].length;j++){

            }
        }
//        return min+1;
        dfs(dungeon,0,0,0);
        return min+1;
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
