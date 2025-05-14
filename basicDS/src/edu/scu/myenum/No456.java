package edu.scu.myenum;

import java.util.TreeMap;

public class No456 {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=2;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //boolean flag = false;
        int premin=nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]>premin){
                Integer index=map.ceilingKey(premin+1);
                if(index!=null&&index<nums[i]){
                    return true;
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
            if(map.get(nums[i])==0){
                map.remove(nums[i]);
            }
            premin=Math.min(premin,nums[i]);
        }
        return false;
    }
}
