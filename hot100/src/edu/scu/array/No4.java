package edu.scu.array;

public class No4 {
    public int[] productExceptSelf(int[] nums) {
        int[] suf=new int[nums.length];
        suf[nums.length-1]=1;
        int cal=1;
        for(int i=nums.length-2;i>=0;i--){
            cal*=nums[i+1];
            suf[i]=cal;
        }
        //int[] res=new int[nums.length];
        cal=1;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=suf[i]*cal;
            cal*=temp;
        }
        return nums;
    }
}
