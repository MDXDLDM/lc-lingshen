package edu.scu.mid;

import java.util.Arrays;

public class No1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int firstindex=0;int lastindex=1;
        long current=0;int max=1;
        while(lastindex< nums.length){
            current+= (long) (nums[lastindex] - nums[lastindex - 1]) *(lastindex-firstindex);
            while(current>k&&firstindex<lastindex){
                current-=(nums[lastindex]-nums[firstindex]);
                firstindex++;
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;
    }
}
