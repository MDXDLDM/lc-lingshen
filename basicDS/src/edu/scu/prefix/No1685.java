package edu.scu.prefix;

public class No1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] postfix=new int[nums.length];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i]=sum;
            sum+=nums[i];
        }
        sum=0;
        for (int i = nums.length - 1; i >= 0; i--) {
            postfix[i]=sum;
            sum+=nums[i];
        }
        int[] res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i]=(nums[i]*i-prefix[i]+postfix[i]-nums[i]*(nums.length-1-i));
        }
        return res;
    }
}
