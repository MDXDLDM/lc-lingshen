package edu.scu.part1;

import java.util.Arrays;
import java.util.HashMap;

public class No3186 {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(power[0],0);
        int size=1;
        for(int i=1;i<power.length;i++){
            if(power[i]!=power[i-1]){
                size++;
                map.put(power[i],0);
            }
        }
        long[] dp=new long[size+1];
        int[] nums=new int[size];
        //long res=0;
        int index=0;
        for(int num:power){
            map.merge(num,1,Integer::sum);
        }
        for (int key : map.keySet()) {
            nums[index++]=key;
        }
        Arrays.sort(nums);
        int pre=0;
        for (int i=0;i<size;i++){
            int x=nums[i];
            long value=(long)x*map.get(x);
            while(nums[pre]<x-2){
                pre++;
            }
            dp[i+1]=Math.max(dp[i],dp[pre]+value);
        }
        return dp[size];
    }
}
