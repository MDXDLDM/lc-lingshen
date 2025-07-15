package edu.scu.part3;

public class No1155 {
    public int numRollsToTarget(int n, int k, int target) {
        //if(target<k) return 0;
        int mod=1000000007;
        int[][] dp=new int[n+1][target+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                for(int m=j;m<=target;m++){
                    if(dp[i-1][m-j]>0){
                        dp[i][m]+=dp[i-1][m-j];
                        dp[i][m]%=mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
