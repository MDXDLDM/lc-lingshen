package edu.scu.hard;

import java.util.Arrays;

public class No719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int right=nums[nums.length-1]-nums[0];
        int left=0;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(check(nums,k,mid)){
                //目前的差小于第k小了
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    private boolean check(int[] nums, int k,int value) {
        for (int i = 0; i < nums.length; i++) {
            k-=(find(nums,nums[i]+value+1)-1-i);//包含了所有小于等于该差的对
        }
        return k>0;
    }
    private int find(int[] nums, int value) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left>>1);
            if(nums[mid]<value){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
