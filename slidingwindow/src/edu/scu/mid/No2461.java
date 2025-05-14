package edu.scu.mid;

import java.util.HashMap;

public class No2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;long max=0;
        int firstindex=0;int lastindex=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(lastindex<nums.length){
            if(lastindex<k){
                sum+=nums[lastindex];
                map.put(nums[lastindex],map.getOrDefault(nums[lastindex],0)+1);
                lastindex++;
                if(map.keySet().size()==k)max=sum;
                continue;
            }
            sum+=nums[lastindex];
            map.put(nums[lastindex],map.getOrDefault(nums[lastindex],0)+1);
            sum-=nums[firstindex];
            if(map.get(nums[firstindex])==1){
                map.remove(nums[firstindex]);
            }else{
                map.put(nums[firstindex],map.getOrDefault(nums[firstindex],0)-1);
            }
            lastindex++;firstindex++;
            if(map.keySet().size()==k)max=Math.max(sum,max);
        }
        return max;
    }
}
