package edu.scu.prefix;

import java.util.HashMap;

public class No560 {
    public int subarraySum(int[] nums, int k) {
//        int res=0;
//        int left1=0;int left2=0;
//        //小于等于减去小于就是等于
//        int right=0;
//        int sum1=0;int sum2=0;
//        while(right<nums.length){
//            sum1+=nums[right];
//            while(left1<right&&sum1>k){
//                left1++;
//                sum1-=nums[left1];
//            }
//            sum2+=nums[right];
//            while(left2<right&&sum2>=k){
//                left2++;
//                sum2-=nums[left2];
//            }
//            res+=left2-left1;
//            right++;
//        }
//        return res;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        sum=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(k+sum)){
                res+=map.get(k+sum);
            }
            sum+=nums[i];
            map.put(sum,map.getOrDefault(sum,0)-1);
        }
        return res;
    }
}
