package edu.scu.array;

public class No1 {
    public int maxSubArray(int[] nums) {
        int res=0;
        int current=0;
        int max=Integer.MIN_VALUE;
        for(int value:nums){
            current+=value;
            if (current<0){
                current=0;
            }
            res=Math.max(res,current);
            max=Math.max(max,value);
        }
        return res==0?max:res;
    }
}
