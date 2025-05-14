package edu.scu.prefix;

import java.util.HashMap;

public class No930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] presum = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            presum[i] = sum;
        }
        //map.put(sum, map.getOrDefault(sum, 0) + 1);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int temp=presum[i];
            //向后寻找
            if(map.containsKey(goal+temp-nums[i])){
                count+=map.get(goal+temp-nums[i]);
            }
            map.put(temp, map.get(temp)-1);
        }
        return count;
    }
}
