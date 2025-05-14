package edu.scu.mystack;

public class No2216 {
    public int minDeletion(int[] nums) {
        int res=1;
        int pre=nums[0];int now;
        for (int i = 1; i < nums.length; i++) {
            now = nums[i];
            if(res%2==1){
                if(now==pre){
                    continue;
                }
            }
            pre=nums[i];
            res++;
        }
        return res%2==0?nums.length-res:nums.length-res+1;
    }
}
