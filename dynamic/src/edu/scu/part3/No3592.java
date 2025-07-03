package edu.scu.part3;

import java.util.LinkedList;
import java.util.List;

public class No3592 {
    public List<Integer> findCoins(int[] numWays) {
        List<Integer> res=new LinkedList<>();
        int[] dp=new int[numWays.length+1];
        dp[0]=1;
        for(int i=0;i<numWays.length;i++){
            if(numWays[i]-dp[i+1]==0){
                continue;
            }else if(numWays[i]-dp[i+1]==1){
                res.add(i+1);
                for(int j=0;j<dp.length-(i+1);j++){
                    if(dp[j]>0){
                        dp[j+(i+1)]+=dp[j];
                    }
                }
            }else{
                return new LinkedList<>();
            }
        }
        return res;
    }
}
