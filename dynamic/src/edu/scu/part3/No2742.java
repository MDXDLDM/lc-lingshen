package edu.scu.part3;

public class No2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n=time.length;
        int[] dp=new int[n+1];
        //Arrays.fill(dp,Integer.MAX_VALUE);
        //dp[0]=0;
        for(int k=0;k<n;k++){
            int value=time[k]+1;
            int costs=cost[k];
            if(value>=n){
                if(dp[n]==0) dp[n]=costs;
                dp[n]=Math.min(dp[n],costs);
            }else{
                for(int j=n-value;j<n;j++){
                    if(dp[j]>0||j==0){
                        if(dp[n]==0) dp[n]=costs+dp[j];
                        dp[n]=Math.min(dp[j]+costs,dp[n]);
                    }
                }
                for(int i=n-1;i>=value;i--){
                    if(dp[i-value]>0||i==value){
                        if(dp[i]==0) dp[i]=dp[i-value]+costs;
                        dp[i]=Math.min(dp[i-value]+costs,dp[i]);
                    }
                }
            }
        }
        return dp[n];
    }
}
