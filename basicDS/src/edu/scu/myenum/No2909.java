package edu.scu.myenum;

public class No2909 {
    public int minimumSum(int[] nums) {
        int res=Integer.MAX_VALUE;
        int[] leftmin=new int[nums.length];
        int[] rightmin=new int[nums.length];
        leftmin[0]=nums[0];rightmin[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            leftmin[i]=Math.min(leftmin[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            rightmin[i]=Math.min(rightmin[i+1],nums[i]);
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>leftmin[i]&&nums[i]>rightmin[i]){
                res=Math.min(res,nums[i]+leftmin[i]+rightmin[i]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
