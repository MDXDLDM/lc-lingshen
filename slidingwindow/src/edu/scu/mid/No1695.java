package edu.scu.mid;

import java.util.HashSet;

public class No1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int current=0;int max=0;
        int firstindex=0;int lastindex=0;
        HashSet<Integer> set=new HashSet<Integer>();
        while(lastindex<nums.length){
            if(set.contains(nums[lastindex])){
                System.out.println(nums[lastindex]);
                while(nums[firstindex]!=nums[lastindex]){
                    current-=nums[firstindex];
                    set.remove(nums[firstindex]);
                    firstindex++;
                }
                current-=nums[firstindex];firstindex++;
            }
            current+=nums[lastindex];
            set.add(nums[lastindex]);
            max=Math.max(max,current);
            lastindex++;
        }
        return max;
    }
}
