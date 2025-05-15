package edu.scu.part1;

public class No2320 {
    public int countHousePlacements(int n) {
        int[] dp = new int[n + 1];
        dp[0]=1;dp[1]=2;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        long res=(long)dp[n]*dp[n];
        return (int)(res%1000000007);
    }
}
