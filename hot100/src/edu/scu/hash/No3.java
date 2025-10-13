package edu.scu.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class No3 {
    public int longestConsecutive(int[] nums) {
        //1
//        if(nums == null || nums.length == 0) return 0;
//        //HashMap<Integer, Integer> map = new HashMap<>();
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int value:nums){
//            //map.put(value, map.getOrDefault(value, 1));
//            set.add(value);
//        }
//        int max = 1;int result=1;
//        int pre=Integer.MIN_VALUE;
//        for(int value:set){
//            System.out.println(value);
//            if(pre==Integer.MIN_VALUE){
//                pre=value;
//                continue;
//            }
//            if(value-pre==1){
//                max++;
//            }else{
//                result=Math.max(result,max);
//                max=1;
//            }
//            pre=value;
//        }
//        result=Math.max(result,max);
//        return result;

        //2
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int value:nums){
            set.add(value);
        }
        int result=0;
        //Set<Integer> cache=new HashSet<>();
        for(int value:set){
            if(set.contains(value-1)){
                continue;
            }
            int record=value;

            //int begin=value;
            while(set.contains(record+1)){
                record++;
            }
            result=Math.max(result,record-value+1);
        }
        return result;
    }
}
