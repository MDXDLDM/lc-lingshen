package edu.scu.part3;

import java.util.List;

public class No2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int size=piles.size();
        int[][] dp=new int[size+1][k+1];//i j 表示选到第i个栈时选j个最大值
        for(List<Integer> list:piles){
            int temp=0;
            for(int i=0;i<list.size();i++){
                temp+=list.get(i);
                list.set(i,temp);
            }
        }
        for(int i=1;i<=size;i++){
            List<Integer> list=piles.get(i-1);
            for(int j=0;j<=k;j++){
                for(int m=1;m<=Math.min(list.size(),k-j);m++){
                    int prefix=list.get(m-1);
                    dp[i][j+m]=Math.max(dp[i][j+m],dp[i-1][j]+prefix);
                }
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
            }
        }
        // int res=0;
        // for(int i=1;i<=size;i++){
        //     //System.out.println(dp[i][k-1]);
        //     res=Math.max(res,dp[i][k]);
        // }
        return dp[size][k];
    }
}
