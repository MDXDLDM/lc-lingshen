package edu.scu.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No3026 {
    public long maximumSubarraySum(int[] nums, int k) {
//        long sum = 0;
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        long[] prefixSum = new long[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            prefixSum[i] = sum;
//            if(!map.containsKey(nums[i])){
//                List<Integer> list = new ArrayList<>();
//                map.put(nums[i], list);
//            }
//            List<Integer> list = map.get(nums[i]);
//            list.add(i);
//        }
//        long max=Long.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int value1=nums[i]+k;
//            int value2=nums[i]-k;
//            long post=prefixSum[i];
//            if(map.containsKey(value1)){
//                List<Integer> list = map.get(value1);
//                for(int key:list){
//                    if(key<i){
//                        max=Math.max(max,post-prefixSum[key]+nums[key]);
//                    }
//                }
//            }
//            if(map.containsKey(value2)){
//                List<Integer> list = map.get(value2);
//                for(int key:list){
//                    if(key<i){
//                        max=Math.max(max,post-prefixSum[key]+nums[key]);
//                    }
//                }
//            }
//        }
//        return max==Long.MIN_VALUE?0:max;
//        long sum=0;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        long[] preSum=new long[nums.length];
//        long max=Long.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum+=nums[i];
//            if(map.containsKey(nums[i])){
//                if(sum<preSum[map.get(nums[i])]){
//                    map.put(nums[i],i);
//                }
//            }else{
//                map.put(nums[i],i);
//            }
//            preSum[i]=sum;
//            if(map.containsKey(nums[i]+k)){
//                int index=map.get(nums[i]+k);
//                max=Math.max(max,sum-preSum[index]+nums[index]);
//            }
//            if(map.containsKey(nums[i]-k)){
//                int index=map.get(nums[i]-k);
//                max=Math.max(max,sum-preSum[index]+nums[index]);
//            }
//        }
//        return max==Long.MIN_VALUE?0:max;
        HashMap<Integer,Long> map = new HashMap<>();
        long sum=0;
        long max=Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])>sum){
                    map.put(nums[i],sum);
                }
            }else{
                map.put(nums[i],sum);
            }
            if(map.containsKey(nums[i]+k)){
                max=Math.max(max,sum-map.get(nums[i]+k)+nums[i]+k);
            }
            if(map.containsKey(nums[i]-k)){
                max=Math.max(max,sum-map.get(nums[i]-k)+nums[i]-k);
            }
        }
        return max==Long.MIN_VALUE?0:max;
    }
}
