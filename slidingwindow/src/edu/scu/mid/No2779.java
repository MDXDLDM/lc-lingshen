package edu.scu.mid;

import java.util.Arrays;
import java.util.HashMap;

public class No2779 {
    public int maximumBeauty(int[] nums, int k) {
//        int[] newnums=new int[nums.length*2];
//        int max=0;int current=0;
//        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for(int i=0;i<nums.length;i++){
//            newnums[i*2]=nums[i]-k;
//            newnums[i*2+1]=nums[i]+k;
//            map.put(newnums[i*2],newnums[i*2+1]);
//        }
//        Arrays.sort(newnums);
//        for(Integer key:map.keySet()){
//            for(int j=0;j<newnums.length;j++){
//                if(newnums[j]>=key&&newnums[j]<map.get(key)){
//                    current++;
//                }
//            }
//            max=Math.max(max,current);
//            current=0;
//        }
//        return max;
        Arrays.sort(nums);
        int max=0;
        int firstindex=0;int lastindex=0;
        while(lastindex<nums.length){
            while(nums[lastindex]-nums[firstindex]>k*2){
                firstindex++;
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;
    }
}
