package edu.scu.part3;

import java.util.Arrays;

public class No3180 {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int sum=0;
        for(int value:rewardValues){
            sum+=value;
        }
        int[] dp=new int[sum+1];
        dp[0]=1;
        for(int i=0;i<rewardValues.length;i++){
            int num=rewardValues[i];
            for(int j=0;j<num;j++){
                if(dp[j]==1){
                    dp[j+num]=1;
                }
            }
        }
        for(int i=sum;i>=0;i--){
            if(dp[i]==1){
                return i;
            }
        }
        return -1;
    }
}
