package edu.scu.part3;

public class No1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        int rows=mat.length;
        int cols=mat[0].length;
        int max=target*2+1;
        int[][] dp=new int[rows+1][max];
        dp[0][0]=1;
        int res=0;
        for(int i=1;i<=rows;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<cols;j++){
                int value=mat[i-1][j];
                min=Math.min(min,value);
                for(int k=value;k<max;k++){
                    if(dp[i-1][k-value]==1){
                        dp[i][k]=1;
                    }
                }
            }
            res+=min;
        }

        for(int i=target;i>=0;i--){
            if(dp[rows][i]==1||dp[rows][target*2-i]==1){
                return target-i;
            }
        }
        return res-target;
    }
}
