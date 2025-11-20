package edu.scu.binarysearch;

public class No4 {
    public int search(int[] nums, int target) {
        return binarysearch(nums,target,nums[0],nums[nums.length-1]);
    }
    private int binarysearch(int[] nums,int target,int min,int max){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left>>1);
            int value=nums[mid];
            if(value==target) return mid;
            if(target<min){
                if(value<min&&value>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(value>=min&&value<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
