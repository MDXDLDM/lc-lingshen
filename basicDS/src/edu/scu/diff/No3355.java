package edu.scu.diff;

public class No3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] on=new int[nums.length];
        int[] off=new int[nums.length+1];
        for (int i = 0; i < queries.length; i++) {
            int start=queries[i][0];
            int end=queries[i][1];
            on[start]+=1;
            off[end+1]+=1;
        }
        //int[] judge=new int[nums.length];
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=on[i]-off[i];
            if(temp<nums[i])return false;
        }
        return true;
    }
}
