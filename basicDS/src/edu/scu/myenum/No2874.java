package edu.scu.myenum;

public class No2874 {
    public long maximumTripletValue(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] suffix=new int[nums.length];
        prefix[0]=nums[0];suffix[nums.length-1]=nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i]=Math.max(nums[i-1],prefix[i-1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i]=Math.max(nums[i+1],suffix[i+1]);
        }
        long max=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,(long)(prefix[i]-nums[i])*suffix[i]);
        }
        return max;
    }

}
