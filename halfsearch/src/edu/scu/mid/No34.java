package edu.scu.mid;

public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start=getstart(nums, target);
        //分别代表所有数都比target小或者所有数都比target大或者没有这个数
        if(start== nums.length||nums[start]!=target){
            return new int[]{-1,-1};
        }
        int end=getstart(nums,target+1)-1;
        return new int[]{start,end};
    }
    private int getstart(int[] nums, int target) {
        int firstindex=0;int lastindex=nums.length-1;//左闭右闭
        while(firstindex<=lastindex){
            int mid=firstindex+(lastindex-firstindex>>2);
            if(nums[mid]>=target){
                lastindex=mid-1;
            }else if(nums[mid]<target){
                firstindex=mid+1;
            }
        }
        return firstindex;
    }
}
