package edu.scu.prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        long[] presum = new long[nums.length];
        long sum=0;
        for (int i = 0; i < nums.length; i++) {
            presum[i] = sum;
            sum+=nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int index=getindex(nums, queries[i]);//大于等于query的第一个下标
            //long temp=index==nums.length?sum:presum[index];
            long left;
            long right;
            if(index==nums.length){
                left=(long)queries[i]*(nums.length)-sum;
                right=0;
            }else{
                left=(long)queries[i]*(index)-presum[index];
                right=sum-presum[index]-(long)queries[i]*(nums.length-index);
            }
            list.add(left+right);
        }
        return list;
    }
    private int getindex(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
