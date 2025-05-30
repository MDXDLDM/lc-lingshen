package edu.scu.part3;

public class No3082 {
    public int sumOfPower(int[] nums, int k) {
        int mod=1000000007;
        int res=0;
        int[] dp=new int[k+1];
        dp[0]=1;
        for(int j=0;j<nums.length;j++){
            //res+=dp[k];
            int value=nums[j];
            for(int i=k;i>=0;i--){
                if(dp[i]>0&&i+value<=k){
                    dp[i+value]+=dp[i];
                    dp[i+value]%=mod;
                }
                dp[i]*=2;
                dp[i]%=mod;
            }
        }
        return dp[k];
    }
}
