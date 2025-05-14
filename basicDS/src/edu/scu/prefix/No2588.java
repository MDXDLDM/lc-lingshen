package edu.scu.prefix;

import java.util.HashMap;

public class No2588 {
    public long beautifulSubarrays(int[] nums) {
        long res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int tool=0;//如果每一位上的1都是偶数，那么异或结果一定为0
        for(int value:nums){
            tool^=value;
            res+=map.getOrDefault(tool,0);
            map.put(tool,map.getOrDefault(tool,0)+1);
        }
        return res;
    }
}
