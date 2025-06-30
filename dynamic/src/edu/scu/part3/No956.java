package edu.scu.part3;

import java.util.Arrays;

public class No956 {
    public int tallestBillboard(int[] rods) {
//        int sum=0;
//        for(int num:rods){
//            sum+=num;
//        }
//        int[] dp=new int[sum/2];
//        dp[0]=1;
//        for(int num:rods){
//            for(int i=0;i<sum/2-num;i++){
//                if(dp[i]>0){
//                    dp[i+num]+=dp[i];
//                }
//            }
//        }
//        int max=0;
//        for(int i=0;i<sum/2;i++){
//            if(dp[i]>1){
//                max=i;
//            }
//        }
//        return max;
        int sum=0;
        for(int num:rods){
            sum+=num;
        }
        int[][] dp=new int[rods.length+1][sum*2+1];//dp[i][j]表示选到第i个钢筋时，若左右高度差为j(-m)时，左边的最大高度
        for(int[] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        dp[0][sum]=0;
        for(int i=1;i<=rods.length;i++){
            int value=rods[i-1];
            for(int j=0;j<sum*2+1;j++){
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                if(j-value>=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-value]+value);
                }
                if(j+value<sum*2+1){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j+value]);
                }
            }
        }
        return dp[rods.length][sum];
    }
}
