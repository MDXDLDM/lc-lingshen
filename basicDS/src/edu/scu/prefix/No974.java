package edu.scu.prefix;

import java.util.HashMap;

public class No974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //System.out.println(-1%2);
            int temp=(sum%k+k)%k;
            if(map.containsKey(temp)){
                count += map.get(temp);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return count;
    }
}
