package edu.scu.array;

import java.util.HashSet;

public class No5 {
    public int firstMissingPositive(int[] nums) {
        int[] set = new int[nums.length+1];
        int tobefound=1;
        for(int num:nums){
            if(num<set.length&&num>=0){
                set[num]=1;
            }
            while(tobefound< set.length&&set[tobefound]==1){
                tobefound++;
            }
        }
        return tobefound;
    }
}
