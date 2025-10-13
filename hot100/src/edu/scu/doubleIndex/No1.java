package edu.scu.doubleIndex;

public class No1 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int goforward=0;
        while(goforward<nums.length){
            if(nums[goforward]!=0){
                nums[index++]=nums[goforward];
            }
            goforward++;
        }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
