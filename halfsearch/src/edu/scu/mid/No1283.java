package edu.scu.mid;

import java.util.Arrays;

public class No1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        int firstindex=1;int lastindex=max;
        int min=max;
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            int tempsum=getres(nums,mid);
            if(tempsum>threshold){
                //说明商大了，需要增大除数，所以是更新firstindex
                firstindex=mid+1;
            }else{
                min=Math.min(min,mid);
                lastindex=mid-1;
            }
        }
        return min;
    }
    private int getres(int[] nums, int value){
        int sum=0;
        for(int key: nums){
            sum+=(key-1)/value+1;
        }
        return sum;
    }
}
