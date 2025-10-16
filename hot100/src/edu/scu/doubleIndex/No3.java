package edu.scu.doubleIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //int len = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int leftindex=i+1;
            int rightindex=nums.length-1;
            while(leftindex<rightindex){
                int sum=nums[i]+nums[leftindex]+nums[rightindex];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[leftindex],nums[rightindex]));
                    while(leftindex<rightindex&&nums[leftindex]==nums[leftindex+1]) leftindex++;
                    while(rightindex>leftindex&&nums[rightindex]==nums[rightindex-1]) rightindex--;
                    leftindex++;
                    rightindex--;
                }else if(sum<0){
                    leftindex++;
                }else{
                    rightindex--;
                }
            }
        }
        return res;
    }
}
