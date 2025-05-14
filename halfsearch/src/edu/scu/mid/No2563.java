package edu.scu.mid;

import java.util.Arrays;

public class No2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
//        long res=0;
//        long[] newnums=new long[nums.length*(nums.length-1)];
//        long count=0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if(j==i) continue;
//                newnums[Math.toIntExact(count++)]=(long)nums[i]*nums[j];
//            }
//        }
//        Arrays.sort(newnums);
//        long start1=getstart(newnums,lower);
//        long start2=getstart(newnums,upper+1)-1;
//        return start2-start1+1;
        long res=0;
        Arrays.sort(nums);
        for(int key:nums){
            int start1=getstart(nums,lower-key);
            int start2=getstart(nums,upper-key+1)-1;
            res+=(start2-start1+1);
            if(key*2>=lower&&key*2<=upper){
                res--;
            }
        }
        return res>>1;
    }
    private int getstart(int[] nums,int target){
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
