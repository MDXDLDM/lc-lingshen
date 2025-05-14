package edu.scu.mid;

import java.util.Arrays;

public class No2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int maxlen= nums.length>>1;
        int minlen=0;
        while(minlen<=maxlen){
            int mid=minlen+(maxlen-minlen>>1);
            int count=0;
            for(int i=0;i<mid;i++){
                if(nums[i]*2<=nums[nums.length-mid+i]){
                    count++;
                }
            }
            if(count<mid){
                //说明此时mid取大了
                maxlen=mid-1;
            }else{
                minlen=mid+1;
            }
        }
        return maxlen*2;
    }
}
