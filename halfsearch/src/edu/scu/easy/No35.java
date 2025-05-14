package edu.scu.easy;

public class No35 {
    public int searchInsert(int[] nums, int target) {
        int startindex=0;int lastindex=nums.length-1;//左闭右闭
        while(startindex<=lastindex){
            int mid=startindex+(lastindex-startindex>>1);
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                startindex=mid+1;
            }else{
                lastindex=mid-1;
            }
        }
        return startindex;
    }
}
