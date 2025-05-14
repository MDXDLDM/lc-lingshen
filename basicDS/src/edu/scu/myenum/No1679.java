package edu.scu.myenum;

import java.util.Arrays;

public class No1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int firstindex=0;
        int lastindex=nums.length-1;
        int count=0;
        while(firstindex<lastindex){
            if(nums[firstindex]+nums[lastindex]==k){
                count++;
                firstindex++;lastindex--;
            }else if(nums[firstindex]+nums[lastindex]<k){
                firstindex++;
            }else{
                lastindex--;
            }
        }
        return count;
    }
}
