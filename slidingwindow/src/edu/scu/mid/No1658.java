package edu.scu.mid;

public class No1658 {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum==x)return nums.length;
        int goal=sum-x;int max=0;
        int firstindex=0;int lastindex=0;
        int current=0;
        while(lastindex<nums.length){
            current+=nums[lastindex];
            while(current>goal&&firstindex<=lastindex){
                current-=nums[firstindex];
                firstindex++;
            }
            if(current==goal){
                max=Math.max(max,lastindex-firstindex+1);
            }
            lastindex++;
        }
        return max==0?-1:nums.length-max;
    }
}
