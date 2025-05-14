package edu.scu.mid;

import java.util.Arrays;

public class No1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] newnums= nums1.clone();
        Arrays.sort(newnums);
        int max=0;
        long sum=0;
        for (int i = 0; i < nums1.length; i++) {
            int temp=Math.abs(nums1[i]-nums2[i]);
            sum+=temp;
            if(temp==0) continue;
            int index=findstart(newnums,nums2[i]);
            int comp=0;
            if(index==0){
                comp=newnums[index]-nums2[i];
            }else if(index==nums1.length){
                comp=-newnums[index-1]+nums2[i];
            }else{
                comp=Math.min(Math.abs(nums2[i]-newnums[index]),Math.abs(nums2[i]-newnums[index-1]));
            }
            max=Math.max(max,temp-comp);
        }
        sum-=max;
        sum%=(1e9+7);
        return (int)sum;
    }
    private int findstart(int[] nums,int target){
        int firstindex=0;
        int lastindex=nums.length-1;
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>1);
            if(nums[mid]>=target){
                lastindex=mid-1;
            }else{
                firstindex=mid+1;
            }
        }
        return firstindex;
    }
}
