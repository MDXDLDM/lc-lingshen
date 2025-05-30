package edu.scu.part3;

public class No879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp=new int[n+1][minProfit+1];
        dp[0][0]=1;
        for(int i=0;i<group.length;i++){
            int cost=group[i];
            int value=profit[i];
            for(int j=n-cost;j>=0;j--){
                for(int k=0;k<=minProfit;k++){
                    if(dp[j][k]>0){
                        //System.out.println(j+" "+k);
                        int pos=Math.min(minProfit,value+k);
                        dp[j+cost][pos]+=dp[j][k];
                        dp[j+cost][pos]%=1000000007;
                    }
                }
            }
        }
        int res=0;
        for(int i=0;i<=n;i++){
            res+=dp[i][minProfit];
            res%=1000000007;
        }
        return res;
    }
}
