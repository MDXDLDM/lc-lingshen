package edu.scu.easy;

public class No2529 {
    public int maximumCount(int[] nums) {
        int start=getstart(nums,0);
        int end=getstart(nums,1)-1;
        return Math.max(start,nums.length-end-1);
    }
    private int getstart(int[] nums,int target) {
        int firstindex=0;int lastindex=nums.length-1;//左闭右闭
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
