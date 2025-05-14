package edu.scu.prefix;

public class No3381 {
    public long maxSubarraySum(int[] nums, int k) {
        long sum=0;long res=Long.MIN_VALUE;
        long[] presum=new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            presum[i]=sum;
            sum+=nums[i];
            if(i>k){
                res=Math.max(res,presum[i]-presum[i-k]);
                presum[i]=Math.min(presum[i],presum[i-k]);
            }
        }
        res=Math.max(res,sum-presum[nums.length-k]);
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(-1%2);
//    }
}
