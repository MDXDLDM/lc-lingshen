package edu.scu.myenum;

public class No1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1=0;
        int index=0;
        while(index<firstLen){
            max1+=nums[index++];
        }
        int tempsum1=0;
        int tempsum2=max1;
        for(int i=index;i<secondLen+index;i++){
            tempsum1+=nums[i];
        }
        int res=max1+tempsum1;
        for(;index+secondLen<nums.length;index++){
            tempsum2=tempsum2+nums[index]-nums[index-firstLen];
            max1=Math.max(max1,tempsum2);
            tempsum1=tempsum1-nums[index]+nums[index+secondLen];
            System.out.println(max1+" "+tempsum1);
            res=Math.max(res,tempsum1+max1);
        }
        index=0;
        max1=0;
        while(index<secondLen){
            max1+=nums[index++];
        }
        tempsum1=0;
        tempsum2=max1;
        for(int i=index;i<firstLen+index;i++){
            tempsum1+=nums[i];
        }
        res=Math.max(res,tempsum1+max1);
        for(;index+firstLen<nums.length;index++){
            tempsum2=tempsum2+nums[index]-nums[index-secondLen];
            max1=Math.max(max1,tempsum2);
            tempsum1=tempsum1-nums[index]+nums[index+firstLen];
            res=Math.max(res,tempsum1+max1);
        }
        return res;
    }
}
