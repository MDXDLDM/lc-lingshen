package edu.scu.part1;

import java.util.Arrays;

public class No740 {
    public int deleteAndEarn(int[] nums) {
        int size=0;
        for (int num : nums){
            size=Math.max(size,num);
        }
        int[] dp=new int[size+1];
        for (int num : nums){
            dp[num]+=num;
        }
        int b2=0;int b1=0;
        for (int num : dp){
            int thisnum=Math.max(num+b2,b1);
            b2=b1;
            b1=thisnum;
        }
        return b1;
    }
}
