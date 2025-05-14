package edu.scu.mid;

public class No1004 {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int firstindex=0;int lastindex=0;
        int count=0;
        while(lastindex<nums.length){
            if(nums[lastindex]==0){
                count++;
            }
            while(count>k&&firstindex<=lastindex){
                if(nums[firstindex]==0){
                    count--;
                }
                firstindex++;
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;
    }
}
