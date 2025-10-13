package edu.scu.part4;

import java.util.Arrays;

public class No3290 {
    public long maxScore(int[] a, int[] b) {
        int lena=a.length;
        int lenb=b.length;
        long[][] dp=new long[lenb+1][lena+1];
        Arrays.fill(dp[0],Long.MIN_VALUE/2);
        dp[0][0]=0;
        for(int i=1;i<=lenb;i++){
            //dp[i][0]=Integer.MIN_VALUE/2;
            for(int j=1;j<=lena;j++){
                dp[i][j]=Math.max(dp[i-1][j-1]+(long)a[j-1]*b[i-1],dp[i-1][j]);
            }
        }
        return dp[lenb][lena];
    }
}
