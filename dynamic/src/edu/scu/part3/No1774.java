package edu.scu.part3;

public class No1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int up=target*2;
        int[] dp=new int[up+1];
        //dp[0]=1;
        int res=baseCosts[0];
        for(int value:baseCosts){
            int a=Math.abs(value-target);
            int b=Math.abs(res-target);
            if(a<b){
                res=value;
            }else if(a==b&&value<res){
                res=value;
            }
            if(value<=up){
                dp[value]=1;
            }
        }
        for(int value:toppingCosts){
            for(int i=up;i>=0;i--){
                if(dp[i]==1){
                    if(i+value<=up){
                        dp[i+value]=1;
                    }
                    if(i+value*2<=up){
                        dp[i+value*2]=1;
                    }
                }
            }
        }
        int index=0;
        while(index<=target){
            if(dp[target-index]==1){
                return target-index;
            }
            if(dp[target+index]==1){
                return target+index;
            }
            index++;
        }
        return res;
    }
}
