package edu.scu.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value=nums[i];
            if (map.containsKey(target-value)) {
                return new int[]{map.get(target-value), i};
            }
            map.put(value, i);
        }
        return null;
    }
}
