package edu.scu.part3;

public class LCP47 {
    public int securityCheck(int[] capacities, int k) {
        int[] dp=new int[k+1];
        dp[0]=1;
        for(int capacity:capacities){
            for(int i=k;i>=capacity-1;i--){
                if(dp[i-capacity+1]>0){
                    dp[i]+=dp[i-capacity+1];
                    dp[i]%=1000000007;
                }
            }
        }
        return dp[k];
    }
}
