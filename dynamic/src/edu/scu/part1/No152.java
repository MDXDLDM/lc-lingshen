package edu.scu.part1;

public class No152 {
    public int maxProduct(int[] nums) {
        int positive=1;
        int max=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            positive*=nums[i];
            max=Math.max(max,positive);
            if (positive==0){
                positive=1;
            }
        }
        positive=1;
        for (int i=nums.length-1; i>=0; i--) {
            positive*=nums[i];
            max=Math.max(max,positive);
            if (positive==0){
                positive=1;
            }
        }
        return max;
    }
}
