package edu.scu.diff;

public class No995 {
    public int minKBitFlips(int[] nums, int k) {
        int[] dec=new int[nums.length+1];
        int count=0;int res=0;
        for (int i = 0; i <= nums.length-k; i++) {
            count+=dec[i];
            if((nums[i]+count)%2==0){
                count++;
                res++;
                dec[i+k]--;
            }
        }
        int index=nums.length-k+1;
        while(index<nums.length){
            count+=dec[index];
            if((nums[index]+count)%2==0)return -1;
            index++;
        }
        return res;
    }
}
