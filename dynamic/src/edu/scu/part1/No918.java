package edu.scu.part1;

public class No918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int min=0;int max=Integer.MIN_VALUE;
        int maxf=0;int minf=0;
        for (int num:nums){
            int maxt=Math.max(maxf,0)+num;
            int mint=Math.min(minf,0)+num;
            max=Math.max(maxt,max);
            min=Math.min(mint,min);
            maxf=maxt;
            minf=mint;
            sum+=num;
        }
        return min==sum?max:Math.max(sum-min,max);
    }
}
