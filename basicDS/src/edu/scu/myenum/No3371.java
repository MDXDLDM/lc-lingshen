package edu.scu.myenum;

import java.util.HashMap;

public class No3371 {
    public int getLargestOutlier(int[] nums) {
        int sum=0;
        int max=-1000;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp=sum-nums[i]*2;
            if(map.containsKey(temp)){
                if(map.get(temp)==1&&temp==nums[i]){
                    continue;
                }
                max=Math.max(max,temp);
            }
        }
        return max;
    }
}
