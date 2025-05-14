package edu.scu.easy;

import java.util.Arrays;

public class No2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
//        int[] ans = new int[queries.length];
//        Arrays.sort(nums);
//        for (int i = 0; i < queries.length; i++) {
//            int count = 0;
//            while(queries[i]>0&&count<nums.length){
//                queries[i]-=nums[count];
//                count++;
//            }
//            ans[i] = queries[i]>=0? nums.length : count-1;
//        }
//        return ans;
        int[] ans = new int[queries.length];
        int[] newnums=new int[nums.length];
        Arrays.sort(nums);
        newnums[0]=nums[0];
        for (int i = 1; i < newnums.length; i++) {
            newnums[i]=newnums[i-1]+nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start=findstart(newnums,queries[i]);
            ans[i]=start;
        }
        return ans;
    }
    private int findstart(int[] nums,int target){
        int startindex=0;
        int lastindex=nums.length-1;//左闭右闭
        while(startindex<=lastindex){
            int mid=(lastindex-startindex>>1)+startindex;
            if(nums[mid]>=target){
                lastindex=mid-1;
            }else{
                startindex=mid+1;
            }
        }
        return startindex;
    }
}
