package edu.scu.myqueue;

import java.util.*;

public class No1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>((p,q)->q-p);
        int firstindex=0;int lastindex=0;
        int max=0;
        while(lastindex<nums.length){
            map.put(nums[lastindex],map.getOrDefault(nums[lastindex],0)+1);
            while(map.firstKey()-map.lastKey()>limit){
                map.put(nums[firstindex], map.get(nums[firstindex]) - 1);
                if(map.get(nums[firstindex])==0){
                    map.remove(nums[firstindex]);
                }
                firstindex++;
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;

    }
}
