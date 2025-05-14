package edu.scu.mid;

import java.util.HashMap;

public class No2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int firstindex=0;int lastindex=0;
        while(lastindex<nums.length){
            map.put(nums[lastindex], map.getOrDefault(nums[lastindex], 0) + 1);
            if(map.get(nums[lastindex]) > k){
                while(nums[firstindex]!=nums[lastindex]){
                    map.put(nums[firstindex], map.getOrDefault(nums[firstindex], 0) - 1);
                    firstindex++;
                }
                firstindex++;
                map.put(nums[lastindex], k);
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;
    }
}
