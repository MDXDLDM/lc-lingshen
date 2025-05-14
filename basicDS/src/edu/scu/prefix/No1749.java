package edu.scu.prefix;

public class No1749 {
    public int maxAbsoluteSum(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int presum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum+=nums[i];
            max=Math.max(max,presum);
            min=Math.min(min,presum);
        }
        return Math.max(Math.abs(max-min),Math.max(Math.abs(min),max));
    }
}
