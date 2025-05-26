package edu.scu.part3;

import java.util.List;

public class No2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum<target){
            return -1;
        }
        int[] dp=new int[target+1];
        for(int i=0;i<nums.size();i++){
            int value=nums.get(i);
            for(int j=target;j>=1;j--){
                if(j-value>=0&&(dp[j-value]>0||j-value==0)){
                    dp[j]=Math.max(dp[j],dp[j-value]+1);
                }
            }
        }
        return dp[target]==0?-1:dp[target];
    }
}
