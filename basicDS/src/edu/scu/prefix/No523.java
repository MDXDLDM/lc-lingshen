package edu.scu.prefix;

import java.util.HashMap;

public class No523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;int presum=0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            presum=sum;
            sum += nums[i];
            int temp=(sum%k+k)%k;
            int pretemp=(presum%k+k)%k;
            if(map.containsKey(temp)){
                if(i==0||(map.get(temp)==1&&pretemp==temp)){

                }else{
                    return true;
                }
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return false;
    }
}
