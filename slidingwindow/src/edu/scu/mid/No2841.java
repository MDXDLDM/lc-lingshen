package edu.scu.mid;

import java.util.HashMap;
import java.util.List;

public class No2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;long max=0;
        int firstindex=0;int lastindex=0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        while(lastindex<nums.size()) {
            if(lastindex<k){
                sum+=nums.get(lastindex);
                map.put(nums.get(lastindex),map.getOrDefault(nums.get(lastindex),0)+1);
                lastindex++;
                if(map.keySet().size()>=m)max=sum;
                continue;
            }
            sum+=nums.get(lastindex);
            map.put(nums.get(lastindex),map.getOrDefault(nums.get(lastindex),0)+1);
            sum-=nums.get(firstindex);
            if(map.get(nums.get(firstindex))==1){
                map.remove(nums.get(firstindex));
            }else{
                map.put(nums.get(firstindex),map.getOrDefault(nums.get(firstindex),0)-1);
            }
            firstindex++;lastindex++;
            if(map.keySet().size()>=m)max=Math.max(sum,max);
        }
        return max;
    }
}
