package edu.scu.part1;

public class No2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        int res=0;
        dp[0]=1;
        for (int i = 1; i <= high; i++){
            if(i>=zero){
                dp[i]+=dp[i-zero];
            }
            if(i>=one){
                dp[i]=(dp[i]+dp[i-one])%1000000007;
            }
            if (i>=low){
                res+=dp[i];
                res%=1000000007;
            }
        }
        return res;
    }
}
