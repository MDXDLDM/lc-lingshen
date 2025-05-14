package edu.scu.prefix;

import java.util.HashMap;

public class No525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int res=0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]==0?-1:1;
            if(map.containsKey(sum)){
                res=Math.max(res,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return res;
    }
}
