package edu.scu.part3;

public class No2518 {
    public int countPartitions(int[] nums, int k) {
        int[] dp=new int[k];
//        long sum=0;
//        for (int num:nums){
//            sum+=num;
//        }
        int mod=1000000007;
        int ans=1;
        dp[0]=1;
        for(int num:nums){
            ans=ans*2%mod;
            for(int i=k-1;i>=num;i--){
                dp[i]=dp[i]+dp[i-num];
            }
        }
        //ans+=mod;
        for(int i=k-1;i>=0;i--){
            ans=(ans+mod-dp[i]*2)%mod;
        }
        return ans%mod;
    }
}
