package edu.scu.part3;

public class No2787 {
    public int numberOfWays(int n, int x) {
        int mod=1000000007;
        int total=1;
        while(true){
            if(Math.pow(total,x)>n){
                break;
            }
            total++;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        int sum=0;
        for(int i=1;i<total;i++){
            int value=(int)Math.pow(i,x);
            sum+=value;
            int target=sum<n?sum:n;
            for(int j=target;j>=1;j--){
                if(j-value>=0){
                    dp[j]+=dp[j-value];
                    dp[j]%=mod;
                }
            }
        }
        return dp[n];
    }
}
